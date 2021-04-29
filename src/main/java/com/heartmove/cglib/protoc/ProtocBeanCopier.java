package com.heartmove.cglib.protoc;

import com.google.protobuf.*;
import net.sf.cglib.core.*;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ProtocBeanCopier
 * @Description 针对于Protoc Message和Java entity的属性拷贝
 * @Date 2021/3/3 11:55
 * @Created by yasheng.cai
 */
public abstract class ProtocBeanCopier{

    private static final ProtocBeanCopierKey KEY_FACTORY =
            (ProtocBeanCopierKey)KeyFactory.create(ProtocBeanCopierKey.class);
    private static final Type CONVERTER =
            TypeUtils.parseType("net.sf.cglib.core.Converter");
    private static final Type BEAN_COPIER =
            TypeUtils.parseType("cn.swiftpass.cglib.protoc.ProtocBeanCopier");
    private static final Signature COPY =
            new Signature("copy", Type.VOID_TYPE, new Type[]{ Constants.TYPE_OBJECT, Constants.TYPE_OBJECT, CONVERTER });
    private static final Signature CONVERT =
            TypeUtils.parseSignature("Object convert(Object, Class, Object)");

    interface ProtocBeanCopierKey {
        public Object newInstance(String source, String target, boolean useConverter);
    }

    public static ProtocBeanCopier create(Class source, Class target, boolean useConverter) {
        ProtocGenerator gen = new ProtocGenerator();
        gen.setSource(source);
        gen.setTarget(target);
        gen.setUseConverter(useConverter);
        return gen.create();
    }

    abstract public void copy(Object from, Object to, Converter converter);

    public static class ProtocGenerator extends AbstractClassGenerator {
        private static final Source SOURCE = new Source(ProtocBeanCopier.class.getName());
        private Class source;
        private Class target;
        private boolean sourceIsProtoClass;
        private boolean targetIsProtoClass;
        private boolean useConverter;

        private MethodInfo protocMessageBuild;

        public ProtocGenerator() {
            super(SOURCE);
        }

        public void setSource(Class source) {
            if(!Modifier.isPublic(source.getModifiers())){
                setNamePrefix(source.getName());
            }
            this.sourceIsProtoClass = ProtocReflectUtils.isProtoBuilderClass(source);
            if(this.sourceIsProtoClass){
                try {
                    Method method = source.getMethod("build");
                    this.protocMessageBuild = ReflectUtils.getMethodInfo(method);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            this.source = source;
        }


        public void setTarget(Class target) {
            if(!Modifier.isPublic(target.getModifiers())){
                setNamePrefix(target.getName());
            }
            this.targetIsProtoClass = ProtocReflectUtils.isProtoBuilderClass(target);
            this.target = target;
        }

        public void setUseConverter(boolean useConverter) {
            this.useConverter = useConverter;
        }

        @Override
        protected ClassLoader getDefaultClassLoader() {
            return source.getClassLoader();
        }

        @Override
        protected ProtectionDomain getProtectionDomain() {
            return ReflectUtils.getProtectionDomain(source);
        }

        public ProtocBeanCopier create() {
            Object key = KEY_FACTORY.newInstance(source.getName(), target.getName(), useConverter);
            return (ProtocBeanCopier)super.create(key);
        }


        @Override
        public void generateClass(ClassVisitor v) {
            Type sourceType = Type.getType(source);
            Type targetType = Type.getType(target);
            ClassEmitter ce = new ClassEmitter(v);
            ce.begin_class(Constants.V1_8,
                    Constants.ACC_PUBLIC,
                    getClassName(),
                    BEAN_COPIER,
                    null,
                    Constants.SOURCE_FILE);

            EmitUtils.null_constructor(ce);
            CodeEmitter e = ce.begin_method(Constants.ACC_PUBLIC, COPY, null);
            PropertyDescriptor[] getters = sourceIsProtoClass ? ProtocReflectUtils.findProtocPropertyDescriptor(source) : ReflectUtils.getBeanGetters(source);
            PropertyDescriptor[] setters = targetIsProtoClass ? ProtocReflectUtils.findProtocPropertyDescriptor(target) : ReflectUtils.getBeanSetters(target);

            Map<String, MethodInfo> fieldHasValueMethodMap = null;
            if(sourceIsProtoClass){
                fieldHasValueMethodMap = ProtocReflectUtils.getProtoHasValueMethod(source);
            }

            Map names = new HashMap();
            for (int i = 0; i < getters.length; i++) {
                names.put(getters[i].getName(), getters[i]);
            }
            Local targetLocal = e.make_local();
            Local sourceLocal = e.make_local();
            if (useConverter) {
                e.load_arg(1);
                e.checkcast(targetType);
                e.store_local(targetLocal);
                e.load_arg(0);
                e.checkcast(sourceType);
                e.store_local(sourceLocal);
            } else {
                e.load_arg(1);
                e.checkcast(targetType);
                e.load_arg(0);
                e.checkcast(sourceType);

                if(sourceIsProtoClass){
                    // 利用来源对象构建来源的message实例
                    e.invoke(protocMessageBuild);
                }
            }

            for (int i = 0; i < setters.length; i++) {
                PropertyDescriptor setter = setters[i];
                PropertyDescriptor getter = (PropertyDescriptor)names.get(setter.getName());
                if (getter != null) {
                    MethodInfo read = ReflectUtils.getMethodInfo(getter.getReadMethod());
                    MethodInfo write = ReflectUtils.getMethodInfo(setter.getWriteMethod());

                    Class setterParamType = setter.getWriteMethod().getParameterTypes()[0];
                    Class getterReturnType = getter.getReadMethod().getReturnType();
                    if (useConverter) {
                        Type setterType = write.getSignature().getArgumentTypes()[0];
                        e.load_local(targetLocal);
                        e.load_arg(2);
                        e.load_local(sourceLocal);
                        e.invoke(read);
                        e.box(read.getSignature().getReturnType());
                        EmitUtils.load_class(e, setterType);
                        e.push(write.getSignature().getName());
                        e.invoke_interface(CONVERTER, CONVERT);
                        e.unbox_or_zero(setterType);
                        e.invoke(write);
                    } else if (compatible(getter, setter)) {
                        Label label0 = null;
                        if(targetIsProtoClass && getterReturnType.equals(String.class)){
                            label0 = e.make_label();
                            e.dup();
                            e.invoke(read);
                            e.ifnull(label0);
                        }
                        e.dup2();
                        e.invoke(read);
                        e.invoke(write);
                        if(targetIsProtoClass){
                            e.pop();
                            if(getterReturnType.equals(String.class)){
                                e.visitLabel(label0);
                            }
                        }

                    }else if(targetIsProtoClass){
                        e.dup();
                        e.invoke(read);
                        Label label0 = e.make_label();
                        e.ifnull(label0);

                        e.dup2();
                        e.invoke(read);
                        if(PROTOC_WRAPPER_CLASS_MAP.containsKey(setterParamType)){
                            e.unbox_or_zero(TypeUtils.getUnboxedType(TypeUtils.getType(getterReturnType.getName())));
                            e.invoke(ReflectUtils.getMethodInfo(PROTOC_WRAPPER_CLASS_MAP.get(setterParamType)));
                        }
                        e.invoke(write);
                        e.pop();

                        e.visitLabel(label0);
                    }else if(sourceIsProtoClass){

                        assert fieldHasValueMethodMap != null;
                        MethodInfo hasValMethod = fieldHasValueMethodMap.get(setter.getName());
                        Label label0 =  null;
                        if(null != hasValMethod){
                            e.dup();
                            e.invoke(hasValMethod);
                            label0 = e.make_label();
                            e.visitJumpInsn(Opcodes.IFEQ, label0);
                        }

                        e.dup2();
                        e.invoke(read);

                        if(PROTOC_WRAPPER_CLASS_GETTER_MAP.containsKey(getterReturnType)) {
                            e.invoke(ReflectUtils.getMethodInfo(PROTOC_WRAPPER_CLASS_GETTER_MAP.get(getterReturnType)));
                            if (!TypeUtils.isPrimitive(TypeUtils.getType(setterParamType.getName()))) {
                                e.box(TypeUtils.getUnboxedType(TypeUtils.getType(setterParamType.getName())));
                            }
                        }
                        e.invoke(write);

                        if(null != hasValMethod){
                            e.visitLabel(label0);
                        }
                    }
                }
            }
            e.return_value();
            e.end_method();
            ce.end_class();
        }

        private final static Map<Class, Method> PROTOC_WRAPPER_CLASS_MAP = new HashMap<>();
        private final static Map<Class, Method> PROTOC_WRAPPER_CLASS_GETTER_MAP = new HashMap<>();
        static {
            try {
                String ofMethod = "of";
                PROTOC_WRAPPER_CLASS_MAP.put(Int32Value.class, Int32Value.class.getMethod(ofMethod, int.class));
                PROTOC_WRAPPER_CLASS_MAP.put(Int64Value.class, Int64Value.class.getMethod(ofMethod, long.class));
                PROTOC_WRAPPER_CLASS_MAP.put(StringValue.class, StringValue.class.getMethod(ofMethod, String.class));
                PROTOC_WRAPPER_CLASS_MAP.put(FloatValue.class, FloatValue.class.getMethod(ofMethod, float.class));
                PROTOC_WRAPPER_CLASS_MAP.put(DoubleValue.class, DoubleValue.class.getMethod(ofMethod, double.class));
                PROTOC_WRAPPER_CLASS_MAP.put(UInt32Value.class, UInt32Value.class.getMethod(ofMethod, int.class));
                PROTOC_WRAPPER_CLASS_MAP.put(UInt64Value.class, UInt64Value.class.getMethod(ofMethod, long.class));
                PROTOC_WRAPPER_CLASS_MAP.put(BoolValue.class, BoolValue.class.getMethod(ofMethod, boolean.class));

                String getValueMethod = "getValue";

                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(Int32Value.class, Int32Value.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(Int64Value.class, Int64Value.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(StringValue.class, StringValue.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(FloatValue.class, FloatValue.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(DoubleValue.class, DoubleValue.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(UInt32Value.class, UInt32Value.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(UInt64Value.class, UInt64Value.class.getMethod(getValueMethod));
                PROTOC_WRAPPER_CLASS_GETTER_MAP.put(BoolValue.class, BoolValue.class.getMethod(getValueMethod));

                // PROTOC_WRAPPER_CLASS_SET.put(BytesValue.class, BytesValue.class.getMethod("of"));

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

        private static boolean compatible(PropertyDescriptor getter, PropertyDescriptor setter) {
            // TODO: allow automatic widening conversions?
            return setter.getPropertyType().isAssignableFrom(getter.getPropertyType());
        }

        @Override
        protected Object firstInstance(Class type) {
            return ReflectUtils.newInstance(type);
        }

        @Override
        protected Object nextInstance(Object instance) {
            return instance;
        }
    }
}
