package com.study.Stage1.Section4.Task3;

public class DoubleThreadTest {

    public static void main(String[] args) {

        SubThreadOne subThread1 = new SubThreadOne();
        SubThreadTwo subThread2 = new SubThreadTwo();

//        subThread1.setDaemon(true);
//        subThread2.setDaemon(true);
        subThread1.start();
        subThread2.start();

        System.out.println("主线程开始等待...");

        try {
            subThread1.join();
            subThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程等待结束");

    }
}
