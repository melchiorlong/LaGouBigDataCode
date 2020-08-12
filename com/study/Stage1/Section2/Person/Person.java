package com.study.Stage1.Section2.Person;

public class Person {

    private String name;
    private int age;
//    private enum gender{male, female};

    public Person() {
    }

    ;

    public Person(String name, int age) {
        setAge(age);
        setName(name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }



    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("年龄错误");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
    }

    public void eat(String food) {
        System.out.println("食物: " + food);
    }

    public void play(String game) {
        System.out.println("游戏: " + game);
    }


}
