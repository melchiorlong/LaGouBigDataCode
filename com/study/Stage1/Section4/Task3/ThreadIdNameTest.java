package com.study.Stage1.Section4.Task3;

public class ThreadIdNameTest extends Thread{

    public ThreadIdNameTest(String str) {
        super(str);
    }

    @Override
    public void run() {
        System.out.println("子线程的编号是" + getId() + ", 子线程的名称是" + getName());
        setName("zhangfei");
        System.out.println("修改后的子线程的编号是" + getId() + ", 子线程的名称是" + getName());
    }



    public static void main(String[] args) {
        ThreadIdNameTest threadIdNameTest = new ThreadIdNameTest("guanyu");
        threadIdNameTest.start();

        // 获取主线程的id和name
        Thread t1 = Thread.currentThread();
        System.out.println("主2线程的编号是" + t1.getId() + ", 子线程的名称是" + t1.getName());

    }

}
