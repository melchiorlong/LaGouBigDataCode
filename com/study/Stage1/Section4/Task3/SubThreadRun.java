package com.study.Stage1.Section4.Task3;

public class SubThreadRun extends Thread{

    @Override
    public void run() {

//        1、打印1-20之间的所有整数
        for (int i = 1; i <= 20; i++) {
            System.out.println("run方法中：i = " + i);
        }
    }
}
