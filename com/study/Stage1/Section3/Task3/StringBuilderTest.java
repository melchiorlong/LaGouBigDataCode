package com.study.Stage1.Section3.Task3;

public class StringBuilderTest {

    public static void main(String[] args) {

//        使用无参构造
        StringBuilder sb1 = new StringBuilder();
        System.out.println("sb3 = " + sb1);
        System.out.println("sb1 = " + sb1.capacity());
        System.out.println("sb1 = " + sb1.length());

        System.out.println("--------------------------------------------------------");

//        使用参数指定的容量来构造对象并打印容量和长度
        StringBuilder sb2 = new StringBuilder(20);
        System.out.println("sb3 = " + sb2);
        System.out.println("sb2 = " + sb2.capacity());
        System.out.println("sb2 = " + sb2.length());

        System.out.println("--------------------------------------------------------");

//        根据参数指定的字符串内容来构造对象并打印
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println("sb3 = " + sb3);
        System.out.println("sb3 = " + sb3.capacity());
        System.out.println("sb3 = " + sb3.length());
        sb3.delete(0,2);
        System.out.println("sb3 = " + sb3);

        String str = sb3.toString();
        StringBuilder sb4 = new StringBuilder(str);
        System.out.println(sb4);

    }

}



