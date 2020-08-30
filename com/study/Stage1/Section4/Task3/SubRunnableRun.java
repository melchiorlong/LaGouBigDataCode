package com.study.Stage1.Section4.Task3;

public class SubRunnableRun implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("run方法中：i = " + i);
        }
    }
}
