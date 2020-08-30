package com.study.Stage1.Section4.Task3;

public class SubThreadTest {

    public static void main(String[] args) {

        Thread thread1 = new SubThreadRun();
//        直接调用run，本质上等于普通成员方法的调用
//        thread1.run();

//        用于启动线程，虚拟机自动调用run方法
//        相当于又启动了一个线程，加上main方法中的run，等于两个线程
        thread1.start();

        for (int i = 1; i <= 20; i++) {
            System.out.println("=======main方法中：i = " + i);
        }



    }
}
