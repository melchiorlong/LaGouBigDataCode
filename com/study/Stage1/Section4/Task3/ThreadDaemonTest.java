package com.study.Stage1.Section4.Task3;

public class ThreadDaemonTest extends Thread{
    @Override
    public void run() {
        System.out.println(isDaemon()?"是守护线程" : "不是守护线程");

        for (int i = 0; i <= 50; i++) {
            System.out.println("子线程中i = " + i);
        }


    }

    public static void main(String[] args) {
        ThreadDaemonTest tdt = new ThreadDaemonTest();
        tdt.setDaemon(true);
        tdt.start();

        for (int i = 0; i <= 20; i++) {
            System.out.println("======主线程中i = " + i);
        }

    }






}
