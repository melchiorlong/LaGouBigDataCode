package com.study.Stage1.Section4.Task5;

import java.util.Date;

/**
 * @author Administrator
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1、使用数据类型.class的方式可以获取对应类型的Class对象
        Class c1 = String.class;
        System.out.println("c1 = " + c1);
        c1 = int.class;
        System.out.println("c1 = " + c1);
        c1 = void.class;
        System.out.println("c1 = " + c1);

        System.out.println("===================================================");

        // 2、使用对象.getClass()的方式获取对应的Class对象
        String s1 = new String("Hello");
        c1 = s1.getClass();
        System.out.println("c1 = " + c1);
        Integer i1 = 20;
        c1 = i1.getClass();
        System.out.println("c1 = " + c1);

        System.out.println("===================================================");

        // 3、使用包装类.TYPE的方式 获取对应基本数据类型的Class对象
        c1 = Integer.TYPE;
        System.out.println("c1 = " + c1);
        c1 = Integer.class;
        System.out.println("c1 = " + c1);

        System.out.println("===================================================");

        // 4、调用class类型forName()方法来获取对应的class对象
        c1 = Class.forName("java.lang.String");
        System.out.println("c1 = " + c1);
        c1 = Class.forName("java.util.Date");
        System.out.println("c1 = " + c1);

        System.out.println("===================================================");

        // 5、使用类加载器来获取对应Class对象
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        Class aClass = classLoader.loadClass("java.lang.String");
        System.out.println("aClass = " + aClass);


    }

}
