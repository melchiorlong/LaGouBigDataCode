package com.study.Stage1.Section4.Task3;

public class RunnableIdNameTest implements Runnable{
    @Override
    public void run() {
        Thread t1 = Thread.currentThread();
        System.out.println("子线程的编号是" + t1.getId() + ", 名称是" + t1.getName());
        t1.setName("PUBG");
        System.out.println("修改后子线程的编号是" + t1.getId() + ", 名称是" + t1.getName());
    }

    public static void main(String[] args) {

        RunnableIdNameTest runnableIdNameTest = new RunnableIdNameTest();
        Thread t2 = new Thread(runnableIdNameTest, "LOL");
        t2.start();


        Thread t1 = Thread.currentThread();
        System.out.println("主线程的编号是" + t1.getId() + ", 子线程的名称是" + t1.getName());
    }
}
