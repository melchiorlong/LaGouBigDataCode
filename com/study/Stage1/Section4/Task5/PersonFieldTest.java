package com.study.Stage1.Section4.Task5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PersonFieldTest {


    public static void main(String[] args) throws Exception {
        // 1、使用原始方法构造对象以及获取成员变量的数值并打印
        Person p1 = new Person("zhangfei", 30);
//        System.out.println("获取到的成员变量数值为 " + p1.name);

        System.out.println("==============================================================");

        // 2、使用反射机制构造对象以及获取成员变量的数值并打印
        // 2.1 获取Class对象
        Class c1 = Class.forName("com.study.Stage1.Section4.Task5.Person");
        // 2.2 根据Class对象获取对应的构造方法
        Constructor constructor = c1.getConstructor(String.class, int.class);
        // 2.3 使用有参构构造方法得到Person类型的对象
        Object obj = constructor.newInstance("zhangfei", 30);
        // 2.4 根据Class对象获取对应的成员变量信息
        Field field1 = c1.getDeclaredField("name");
        Field field2 = c1.getDeclaredField("age");
        field1.setAccessible(true);
        field2.setAccessible(true);
        // 2.5 使用Person类型的对象来获取成员变量的数值并打印
        System.out.println("获取到的成员变量数据为 " + field1.get(obj));
        System.out.println("获取到的成员变量数据为 " + field2.get(obj));

        System.out.println("==============================================================");

        // 使用原始方式修改成员变量的数值并打印
//        p1.name = "guanyu";
//        p1.age = 40;
//        System.out.println("修改后的成员变量数值为 " + p1.name);
//        System.out.println("修改后的成员变量数值为 " + p1.age);

        System.out.println("==============================================================");

        // 使用放射机制修改制定对象中成员变量的数值并打印
        field1.set(obj, "liubei");
        field2.set(obj, 60);
        System.out.println("修改后的成员变量数据为 " + field1.get(obj));
        System.out.println("修改后的成员变量数据为 " + field2.get(obj));

        System.out.println("==============================================================");

        // 获取Class对象对应类中所有成员变量
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field fd: declaredFields) {
            System.out.println("获取到的访问修饰符是 " + fd.getModifiers());
            System.out.println("获取到的数据类型是 " + fd.getType());
            System.out.println("获取到的成员变量名称是 " + fd.getName());
            System.out.println("-----------------");
        }

        //
        //
        //
    }
}
