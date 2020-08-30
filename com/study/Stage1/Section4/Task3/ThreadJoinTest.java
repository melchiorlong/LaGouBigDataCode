package com.study.Stage1.Section4.Task3;

public class ThreadJoinTest extends Thread{

    @Override
    public void run() {
        // 模拟倒数10个数效果
        System.out.println("倒计时开始：");
        for (int i = 10; i > 0; i--) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("新年快乐");
    }

    public static void main(String[] args) {

        ThreadJoinTest tjt = new ThreadJoinTest();
        tjt.start();

        // 主线程开始等待
        System.out.println("主线成开始等待...");
        Thread t1 = currentThread();
        try {
//            tjt.join();
            tjt.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程开始");

    }


}
