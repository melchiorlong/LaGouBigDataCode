package com.study.Stage1.Section3.Task5;

import java.util.Objects;

/**
 * 自定义泛型，其中T做占位用
 * @param <T> 理解为 T 类型的数据格式
 */
public class Person<T> {

    private String name;
    private int age;
    private T gender;


    public Person() {
    }

    public Person(String name, int age, T gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public T getGender() {
        return gender;
    }

    public void setGender(T gender) {
        this.gender = gender;
    }

    public static <T1> void printArray(T1[] arr){
        for (T1 t: arr
             ) {
            System.out.println("t = " + t);
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person<?> person = (Person<?>) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
