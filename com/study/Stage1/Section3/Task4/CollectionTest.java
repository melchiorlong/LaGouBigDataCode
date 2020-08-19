package com.study.Stage1.Section3.Task4;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {

//    准备一个Collection集合 并打印
//    向集合中添加单个元素
//    向集合中添加多个元素

    public static void main(String[] args) {
//        Collection c1 = new Collection();  // 接口不能实例化
//        接口类型的引用，指向实现类对象，形成多态
        Collection c1 = new ArrayList();
        System.out.println("集合中的元素有：" + c1);

        System.out.println("----------------------------------------------------");

        boolean one = c1.add(new String("one"));
        System.out.println("one = " + one);
        System.out.println("集合中的元素有：" + c1);
        boolean two = c1.add(Integer.valueOf(2));
        System.out.println("two = " + two);
        System.out.println("集合中的元素有：" + c1);
        boolean person = c1.add(new Person("zhangfei", 12));
        System.out.println("person = " + person);
//        打印集合中元素时，实际上是打印集合每个元素，并分别调用toString()方法
        System.out.println("集合中的元素有：" + c1);

        System.out.println("----------------------------------------------------");

        Collection c2 = new ArrayList();
        c2.add("three");
        c2.add(4);
        System.out.println(c2);

//        将c2的所有元素添加到c1中
        c1.addAll(c2);
        System.out.println(c1);

//        判断集合中是否包含参数指定的的单个元素
        boolean one_cons = c1.contains(new String("one"));
        System.out.println(one_cons);
        boolean two_cons = c1.contains(new String("two"));
        System.out.println(two_cons);
        boolean contains = c1.contains(Integer.valueOf(3));
        System.out.println(contains);
        boolean zhangfei = c1.contains(new Person("zhangfei", 12));
        System.out.println(zhangfei);


        System.out.println("----------------------------------------------------");
//        判断集合中是否包含参数指定的的所有元素

        Collection c3 = new ArrayList();
        c3.add(4);
        System.out.println(c3);
        boolean b = c1.containsAll(c3);
        System.out.println(b);
        c3.add("five");
        boolean b1 = c1.containsAll(c3);
        System.out.println(b1);

        System.out.println("----------------------------------------------------");
//        计算两个集合的交集并保存的当前集合中
        System.out.println(c2);
        System.out.println(c3);

        boolean b2 = c2.retainAll(c2);
        System.out.println(b2);
        boolean b3 = c2.retainAll(c3);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(b3);

        System.out.println("----------------------------------------------------");

//        实现集合和数组类型之间的转化
//        1、集合 -> 数组
        Object[] objects = c3.toArray();
        System.out.println(Arrays.toString(objects));

//        2、数组 -> 集合

        Collection objects1 = Arrays.asList(objects);
        System.out.println(objects1);

    }
}
