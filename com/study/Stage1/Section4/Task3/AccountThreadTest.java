package com.study.Stage1.Section4.Task3;

public class AccountThreadTest extends Thread{


    private int balance;
    private static Demo demo = new Demo();

    public AccountThreadTest() {
    }

    public AccountThreadTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "启动");
        synchronized (demo) {
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

        AccountThreadTest att1 = new AccountThreadTest(1000);
        att1.start();
        AccountThreadTest att2 = new AccountThreadTest(1000);
        att2.start();


        System.out.println("主线程开始等待...");
        try {
            att1.join();
            att2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("att1最终账户余额为" + att1.getBalance());
        System.out.println("att2最终账户余额为" + att2.getBalance());
        System.out.println("主线程结束等待");


    }
}
