package com.study.Stage1.Section3.Task5;

import java.util.LinkedList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {

//        声明两个List类型的集合进行测试
        List<Animal> l1 = new LinkedList<>();
        List<Dog> l2 = new LinkedList<>();

        System.out.println("--------------------------------------------------------------------");
        List<?> l3 = new LinkedList<>();
        l3 = l1;
        l3 = l2;

//        l3.add(new Animal());  Error: 不支持元素的添加操作
//        l3.add(new Dog());     Error: 不支持元素的添加操作

        Object o = l3.get(0);

        System.out.println("--------------------------------------------------------------------");
//        使用有限制的通配符
        List<? extends Animal> l4 = new LinkedList<>();
//        l4.add(new Animal()); Error: 不支持元素的添加操作
//        l4.add(new Dog());    Error: 不支持元素的添加操作
        Animal animal = l4.get(0);

        List<? extends Dog> l5 = new LinkedList<>();
        Dog dog = l5.get(0);

        System.out.println("--------------------------------------------------------------------");

        List<? super Animal> l6 = new LinkedList<>();
        l6.add(new Animal());
        l6.add(new Dog());
//        l6.add(new Object());
        Object object = l6.get(0);


    }
}
