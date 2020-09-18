package com.study.Stage1.Section4.Task5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class StudentTest {

    public static void main(String[] args) throws ClassNotFoundException {

        // 获取Student类型的Class对象
        Class c1 = Class.forName("com.study.Stage1.Section4.Task5.Student");
        System.out.println("获取到的包信息是" + c1.getPackage());
        System.out.println("获取到的包名称是" + c1.getPackageName());
        System.out.println("获取到的父类信息是" + c1.getSuperclass());
        System.out.println("获取到的接口信息是：");
        Class[] interfaces = c1.getInterfaces();
        for (Class ct: interfaces) {
            System.out.println("ct = " + ct);
        }
        System.out.println();

        System.out.println("获取到的注解信息是: ");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation a : annotations
             ) {
            System.out.println("a = " + a);
        }
        System.out.println();

        System.out.println("获取到的泛型信息是: ");
        Type[] genericInterfaces = c1.getGenericInterfaces();
        for (Type gen : genericInterfaces
             ) {
            System.out.println("gen = " + gen);
        }


        // 获取父类信息是
        //
        //
        //
        //
        //

    }
}
