package com.study.Stage1.Section4.Task3;

public class AccountRunnableTest implements Runnable {

    private int balance;
    private Demo demo = new Demo();

    public AccountRunnableTest() {
    }

    public AccountRunnableTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public /*synchronized*/ void run() {
        synchronized (this) {
            System.out.println("线程" + Thread.currentThread().getName() + "启动");
            // 1、模拟从后台查询账户余额的过程
            int temp_balance = getBalance();
            // 2、取款200元的过程
            if (temp_balance >= 200) {
                System.out.println("正在取钱，请稍后...");
                temp_balance -= 200;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请取钱");
            } else {
                System.out.println("余额不足。");
            }
            // 3、将最新的账户余额写入后台
            setBalance(temp_balance);
        }
    }


    public static void main(String[] args) {

        AccountRunnableTest art = new AccountRunnableTest(1000);
        Thread t1 = new Thread(art);
        Thread t2 = new Thread(art);
        t1.start();
        t2.start();


        System.out.println("主线程开始等待...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终账户余额为" + art.getBalance());
        System.out.println("主线程结束等待");

    }
}

class Demo {
}