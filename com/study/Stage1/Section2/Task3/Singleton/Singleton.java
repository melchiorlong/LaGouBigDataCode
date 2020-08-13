package com.study.Stage1.Section2.Task3.Singleton;

public class Singleton {

//    private static final Singleton singleton = new Singleton(); //饿汉式
    private static Singleton singleton = null;
    private Singleton(){}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
