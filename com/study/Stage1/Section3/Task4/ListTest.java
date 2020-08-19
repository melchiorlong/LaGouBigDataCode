package com.study.Stage1.Section3.Task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

//        声明一个List接口类型 ，指向ArrayList，形成多态
        List list1 = new ArrayList();
        list1.add("one");
        System.out.println("list1 = " + list1);

        System.out.println("-----------------------------------");

//        声明一个List接口类型的 指向LinkedList，行程多态
        List list2 = new LinkedList();
        list2.add("two");
        System.out.println("list2 = " + list2);





    }

}
