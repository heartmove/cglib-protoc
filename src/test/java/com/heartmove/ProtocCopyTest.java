package com.heartmove;

import com.heartmove.cglib.protoc.ProtocBeanCopier;
import com.example.demo.proto.Person3;
import com.google.protobuf.Int32Value;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ProtocCopyTest
 * @Description TODO
 * @Date 2021/3/1 16:09
 * @Created by yasheng.cai
 */

public class ProtocCopyTest {


    @Test
    public void equalsTypeTest(){
        List<String> carList = new ArrayList<>();
        carList.add("audi");
        Person3.Builder source = Person3.newBuilder().setAge(10).setJobName("car").addAllCars(carList).setHeight(Int32Value.of(144));
        Person3.Builder target = Person3.newBuilder();

        ProtocBeanCopier beanCopier = ProtocBeanCopier.create(Person3.Builder.class, Person3.Builder.class, false);
        beanCopier.copy(source, target, null);
        System.out.println(target.getAge());
        System.out.println(target.getHeight());
        System.out.println(target.getJobName());
        System.out.println(target.getCarsList());
    }

    @Test
    public void normalTypeTest() throws Exception{
        List<String> carList = new ArrayList<>();
        carList.add("audi");
        PersonDto source = new PersonDto();
        source.setAge(10);
        source.setJobName("driver");
        //source.setHeight(155);
        source.setCars(carList);
        Person3.Builder target = Person3.newBuilder();

        ProtocBeanCopier beanCopier = ProtocBeanCopier.create(PersonDto.class, Person3.Builder.class, false);
        beanCopier.copy(source, target, null);
        System.out.println("age:" + target.getAge());
        System.out.println("height:"+target.getHeight());
        System.out.println("jobName:"+target.getJobName());
        System.out.println("cars:"+target.getCarsList());
        target.hasHeight();
    }


    @Test
    public void targetNormalTypeTest(){
        List<String> carList = new ArrayList<>();
        carList.add("audi");
        Person3.Builder source = Person3.newBuilder().setAge(10).setJobName("driver").addAllCars(carList)/*.setHeight(Int32Value.of(144))*/;
        PersonDto target = new PersonDto();

        ProtocBeanCopier beanCopier = ProtocBeanCopier.create(Person3.Builder.class, PersonDto.class, false);
        beanCopier.copy(source, target, null);
        System.out.println("age:" + target.getAge());
        System.out.println("height:"+target.getHeight());
        System.out.println("jobName:"+target.getJobName());
        System.out.println("cars:"+target.getCars());
    }


    private void copy(Object a, Object b, boolean convert){
        PersonDto a1 = (PersonDto)a;
        Person3.Builder b1 = (Person3.Builder)b;
        Integer integer = a1.getHeight();
        if(null != integer){
            b1.setHeight(Int32Value.of(integer));
        }

        int i = 10;
        return;
    }

    private Object test(Object a){
        if(null != a){
            return a;
        }

        return null;
    }

    private void copy2(Object a, Object b, boolean convert){
        PersonDto b1 = (PersonDto)a;
        Person3.Builder a1 = (Person3.Builder)b;
        if(a1.hasHeight()){
            b1.setHeight(a1.getHeight().getValue());
        }
    }


    class PersonDto{
        private String jobName;
        private int age;
        private Integer height;
        private List<String> cars;

        public List<String> getCars() {
            return cars;
        }

        public void setCars(List<String> cars) {
            this.cars = cars;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

}
