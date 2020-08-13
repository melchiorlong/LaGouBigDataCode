package com.study.Stage1.Section2.Task5.AnonymousInterface;

public class AnonymousInterfaceTest {

    public static void test(AnonymousInterface anonymousinterface){
        anonymousinterface.show();
    }

    public static void main(String[] args) {

        AnonymousInterfaceTest.test(new AnonymousInterfaceImpl());

    }
}
