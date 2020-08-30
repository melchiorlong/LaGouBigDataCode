package com.study.Stage1.Section4.Task3;

public class SubRunnableRunTest {

    public static void main(String[] args) {

//        1、创建自定义类型的对象，也就是实现Runnable接口类的对象
        SubRunnableRun sr = new SubRunnableRun();

//        2、使用该对象作为实参构造Thread类型的对象
        Thread t1 = new Thread(sr);

//        3、使用Thread类型的对象调用start方法
        t1.start();


        for (int i = 1; i <= 20; i++) {
            System.out.println("=======main方法中：i = " + i);
        }

    }
}
