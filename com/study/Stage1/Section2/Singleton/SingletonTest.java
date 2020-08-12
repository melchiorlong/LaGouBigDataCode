package com.study.Stage1.Section2.Singleton;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton.equals(singleton1));



    }
}
