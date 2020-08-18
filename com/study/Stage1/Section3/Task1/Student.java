package com.study.Stage1.Section3.Task1;

import java.util.Objects;

public class Student {

    private int id;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        setId(age);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            System.out.println("年龄输入错误");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (this == obj) {
//            return true;
//        }
//        if (obj instanceof Student) {
//            Student ts = (Student) obj;
////            return (this.getId() == ts.getId());
//            return this.getName().equals(ts.getName());
//        } else {
//            return false;
//        }
//    }



//    为了使得hashcode方法与equals方法的结果一致，以满足java官方协定，所以重写hashcode


//    @Override
//    public int hashCode() {
//        return Objects.hash(getName());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +'}';
    }
}
