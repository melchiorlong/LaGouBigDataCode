package com.study.Stage1.Section2.Person;

public class Person {

    String name;
    int age;

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println("我的名字是" + p.name + ",我的年龄是" + p.age);
        p.name = "long0312";
        p.age = 26;
        System.out.println("我的名字是" + p.name + ",我的年龄是" + p.age);

    }
}
