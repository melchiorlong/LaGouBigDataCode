package com.study.Stage1.Section2.Student;

public class Student {
    // 实现Student类封装
    // 私有化成员变量
    // 提供公有的get set方法

    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("学号必须大于0");
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("我是" + name + ",我的学号是: " + id);
    }
}
