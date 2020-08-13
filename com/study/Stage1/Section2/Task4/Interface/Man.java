package com.study.Stage1.Section2.Task4.Interface;

public class Man implements Hunter{

    @Override
    public void hunt() {
        System.out.println("狩猎");
    }

    @Override
    public void run() {
        System.out.println("跑");
    }

    public static void main(String[] args) {

        Runner rn = new Man();
        rn.run();
        Hunter hn = new Man();
        hn.hunt();
    }
}
