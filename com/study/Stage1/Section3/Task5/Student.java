package com.study.Stage1.Section3.Task5;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student>{
     private String name;
     private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(@NotNull Student o) {
//        调用对象和参数对象相等
//        return -1;

//        按照姓名首字母排序
//        return this.getName().compareTo(o.getName());
//        按照年龄排序
        return this.getAge() - o.getAge();


//        return 0;
    }
}
