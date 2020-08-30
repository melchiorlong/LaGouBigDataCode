package com.study.Stage1.Section4.Task3;

public class ThreadPriorityTest extends Thread{


    @Override
    public void run() {
//        System.out.println("子线程的优先级是：" + getPriority());

//        System.out.println("修改后子线程的优先级是：" + getPriority());
        for (int i = 1; i <=100 ; i++) {
            System.out.println("子线程中i = " + i);
        }


    }


    public static void main(String[] args) {

        ThreadPriorityTest tpt = new ThreadPriorityTest();
        tpt.setPriority(MIN_PRIORITY);
        tpt.start();

        Thread t1 = currentThread();
//        System.out.println("主线程的优先级是：" + t1.getPriority());
        for (int i = 1; i <=100 ; i++) {
            System.out.println("========主线程中i = " + i);
        }
    }

}
