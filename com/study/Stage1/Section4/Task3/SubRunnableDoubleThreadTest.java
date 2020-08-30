package com.study.Stage1.Section4.Task3;

public class SubRunnableDoubleThreadTest {

    public static void main(String[] args) {

        SubRunnableThreadOne srt1 = new SubRunnableThreadOne();
        SubRunnableThreadTwo srt2 = new SubRunnableThreadTwo();

        Thread t1 = new Thread(srt1);
        Thread t2 = new Thread(srt2);

        t1.start();
        t2.start();

        System.out.println("主线程开始等待...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程结束等待");

    }



}
