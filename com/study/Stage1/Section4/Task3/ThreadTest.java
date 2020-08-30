package com.study.Stage1.Section4.Task3;

public class ThreadTest {

    public static void main(String[] args) {

//        1、使用无参构造方式 构造Thread类型的对象
        Thread thread1 = new Thread();

//        2、调用run方法
        thread1.run();

//        3、打印一句话
        System.out.println("Nothing to do.");

    }
}
