package com.study.Stage1.Section4.Task3;

public class SubRunnableThreadTwo implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i <= 100 ; i+=2) {
            System.out.println("=====子线程2中i = " + i);
        }
    }
}
