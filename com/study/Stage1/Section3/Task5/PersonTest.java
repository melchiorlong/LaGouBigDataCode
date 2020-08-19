package com.study.Stage1.Section3.Task5;

public class PersonTest {

    public static void main(String[] args) {

//        声明Person类型的引用

        Person p1 = new Person("zhangfei",30,"男");
        System.out.println("p1 = " + p1);

        Person<Boolean> p2 = new Person<>();
        p2.setGender(true);
        System.out.println("p2 = " + p2);


        Integer[] integers = new Integer[]{11,22,33,44,55};
        Person.printArray(integers);

    }

}
