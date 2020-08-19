package com.study.Stage1.Section3.Task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMethodsTest {


    public static void main(String[] args) {

//        准备一个空List集合并打印
        List l1 = new ArrayList<>();
        System.out.println("l1 = " + l1);

        System.out.println("--------------------------------------------");
//        向集合中添加元素并打印
//        向集合各个位置添加元素
        l1.add(0, "one");
        System.out.println("l1 = " + l1);
        l1.add(1,3);
        System.out.println("l1 = " + l1);
        l1.add(1,"two");
        System.out.println("l1 = " + l1);

        System.out.println("--------------------------------------------");

//        根据参数指定的下标获取元素
        String str1 = (String) l1.get(0);
        System.out.println(str1);
        int str2 = (Integer) l1.get(2);
        System.out.println(str2);

        System.out.println("--------------------------------------------");
//        使用get方法，获取所有元素

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for (int i = 0; i < l1.size(); i++) {
            Object obj = l1.get(i);
            if (l1.size() - 1  == i ){
                sb1.append(obj).append("]");
            }else{
                sb1.append(obj).append(", ");
            }
        }
        System.out.println(sb1);

        System.out.println("--------------------------------------------");

        System.out.println("正向查找的位置是 ： " + l1.indexOf("one"));
        l1.add("one");
        System.out.println("反向查找的位置是 ： " + l1.lastIndexOf("one"));

        System.out.println("--------------------------------------------");

//        实现集合中元素的修改

        System.out.println(l1);
        Object three = l1.set(2, "three");
        System.out.println("修改的元素是：" + three);
        System.out.println("修改后的List是：" + l1);

        Object four = l1.set(l1.size() - 1, "four");
        System.out.println("修改的元素是：" + four);
        System.out.println("修改后的List是：" + l1);

        System.out.println("--------------------------------------------");

//        使用remove方法 删除所有元素

//        for (int i = 0; i < l1.size();/* i++*/) {
//            Object remove = l1.remove(0);
//            System.out.println("删除的元素是:" + remove);
//        }
//        System.out.println("删除后的结果是：" + l1);

        System.out.println("--------------------------------------------");

//        获取子集合   子集合和当前集合公用内存空间
        List l2 = l1.subList(0,2);
        l1.subList(0,2);
        System.out.println(l2);
        Object remove = l2.remove(0);
        System.out.println(remove);
        System.out.println(l1);
        System.out.println(l2);

//        List l2 = new ArrayList();
//        l2.addAll(l1.subList(0,2));
    }
}
