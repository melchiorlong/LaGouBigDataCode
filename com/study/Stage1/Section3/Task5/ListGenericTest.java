package com.study.Stage1.Section3.Task5;


import java.util.LinkedList;
import java.util.List;

public class ListGenericTest {

    public static void main(String[] args) {

//       准备一个List集合，向集合中添加元素并打印
        List<String> l1 = new LinkedList<>();
        l1.add("one");
        l1.add("two");
        l1.add("three");
        System.out.println("l1 = " + l1);

        String s = l1.get(0);
        System.out.println(s);

        System.out.println("---------------------------------------");

        List<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        System.out.println("l2 = " + l2);

        int i = l2.get(0);
        System.out.println(i);



    }


}
