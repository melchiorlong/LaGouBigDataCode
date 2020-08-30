package com.study.Stage1.Section4.Task3;

public class SubThreadOne extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i+=2) {
            System.out.println("子线程1中i = " + i);
        }
    }
}
