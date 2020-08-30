package com.study.Stage1.Section4.Task3;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ThreadSleepTest extends Thread {

    private boolean isTicking = true;

    @Override
    public void run() {
        // 每隔一秒获取系统时间 并打印 模拟时钟的效果
        while (isTicking) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//            System.out.println("当前系统时间是 = " + sdf.format(date));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("当前系统时间是 = " + LocalDateTime.now().format(dtf));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ThreadSleepTest tst = new ThreadSleepTest();
        tst.start();
        System.out.println("主线程开始等待...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        tst.stop();
        tst.isTicking = false;
        System.out.println("主线程等待结束。");


    }
}
