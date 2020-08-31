package com.study.Stage1.Section4.Task3;

public class ThreadCommunicateTest implements Runnable {

    private int cnt = 1;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
//              每当有一个线程进来后，唤醒另外一个线程
                notify();
                if (cnt <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + "中：cnt = " + cnt);
                    cnt += 1;
                    try {
//                      当前线程打印一个数据后，为防止打印下一个数据，则调用wait方法
                        wait(); //线程进入阻塞状态，自动释放对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        ThreadCommunicateTest tct = new ThreadCommunicateTest();
        Thread t1 = new Thread(tct);
        Thread t2 = new Thread(tct);
        t1.start();
        t2.start();
    }
}
