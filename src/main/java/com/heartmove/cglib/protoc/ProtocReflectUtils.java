package com.heartmove.cglib.protoc;

import com.google.protobuf.MapField;
import net.sf.cglib.core.MethodInfo;
import net.sf.cglib.core.ReflectUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static java.util.Locale.ENGLISH;

/**
 * @author yasheng.cai
 * @Classname ProtocReflectUtils
 * @Description 针对于Protoc的反射工具类
 * @Date 2021/3/3 13:46
 * @Created by yasheng.cai
 */
public class ProtocReflectUtils {

    /**
     * 获取 builderType对应字段的getter和setter方法
     * @param builderType
     * @return
     */
    public static PropertyDescriptor[] findProtocPropertyDescriptor(Class builderType){
        List<PropertyDescriptor> list = new ArrayList<>();
        Class superClass = builderType.getEnclosingClass();
        getProtoAllField(builderType).forEach((name, fieldType) ->{
            try {
                String capitalizeName = capitalize(name);
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name,
                        getProtoGetterMethod(superClass, fieldType, capitalizeName),
                        getProtoSetterMethod(builderType, fieldType, capitalizeName));
                list.add(propertyDescriptor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return list.toArray(new PropertyDescriptor[list.size()]);
    }

    /**
     * 获取buidler的所有字段
     * @param type   message$Builder
     * @return
     */
    public static Map<String, Class> getProtoAllField(Class type){
        Map<String, Class> fieldMap = new HashMap<>();
        Class superClass = type.getEnclosingClass();
        for (Field field : superClass.getDeclaredFields()) {
            String fieldName = field.getName().replaceAll("_FIELD_NUMBER$", "").toLowerCase(Locale.ROOT);
            if(fieldName.length() == field.getName().length()){
                continue;
            }
            String name = underlineToCamel(fieldName);
            Optional<Field> protoField = Arrays.stream(superClass.getDeclaredFields()).filter(f->f.getName().equals(name+"_")).findFirst();
            if(protoField.isPresent()){
                try {
                    Class fieldType = protoField.get().getType();
                    if(fieldType.equals(Object.class)){
                        fieldType = String.class;
                    }
                    fieldMap.put(name, fieldType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return fieldMap;
    }


    public static Method getProtoGetterMethod(Class type, Class fieldType, String fieldName) throws Exception {
        if (fieldType.getName().startsWith("com.google.protobuf.") && fieldType.getName().contains("List")) {
            return type.getMethod("get" + fieldName + "List");
        } if(fieldType.equals(MapField.class)){
            return type.getMethod("get" + fieldName);
        } else{
            return type.getMethod("get" + fieldName);
        }
    }


    public static Method getProtoSetterMethod(Class type, Class fieldType, String fieldName) throws Exception{
        if(fieldType.getName().startsWith("com.google.protobuf.") && fieldType.getName().contains("List")){
            return type.getMethod("addAll" + fieldName, Iterable.class);
        }if(fieldType.equals(MapField.class)){
            return type.getMethod("putAll" + fieldName, Map.class);
        }else{
            return type.getMethod("set" + fieldName, fieldType);
        }
    }


    /**
     * 是否是protobuf的meesage builder类
     * @param clz
     * @return
     */
    public static boolean isProtoBuilderClass(Class clz){
        if(null == clz.getSuperclass()){
            return false;
        }
        return clz.getSuperclass().getName().startsWith("com.google.protobuf.GeneratedMessage")
                && clz.getName().endsWith("$Builder");
    }

    /**
     * 驼峰命名xxx_abc -> xxxAbc
     */
    public static String underlineToCamel(String name) {
        name = name.trim();
        int len = name.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(name.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean isSetterOrGetter(Method method, Set<String> filedNameSet){
        if(method == null){
            return false;
        }
        String methodName = method.getName();
        int length = methodName.length();
        methodName = methodName.replaceAll("^(set|get|is)", "");
        if(methodName.length() == length){
            return false;
        }
        methodName = capitalize(methodName);
        return filedNameSet.contains(methodName);
    }

    public static String capitalize(String name){
        return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
    }

    /**
     * 获取builder对应的has方法
     * @param type
     * @return
     * @throws Exception
     */
    public static Map<String, MethodInfo> getProtoHasValueMethod(Class type){
        Map<String, MethodInfo> map;
        try {
            map = new HashMap<>();
            Class superClass = type.getEnclosingClass();
            getProtoAllField(type).forEach((name, fieldType) -> {
                try {
                    Method method = superClass.getMethod("has" + capitalize(name));
                    map.put(name, ReflectUtils.getMethodInfo(method));
                } catch (NoSuchMethodException e) {
                }
            });
        } catch (SecurityException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return map;
    }

}
