package com.study.Stage1.Section3.Task5;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {

//        准备一个集合并初始化
        List<Integer> integers = Arrays.asList(1, 4, 7, 3, 7, 8, 2);
        System.out.println("集合中的最大值是：" + Collections.max(integers));
        System.out.println("集合中的最小值是：" + Collections.min(integers));

//        实现集合中元素的反转
        Collections.reverse(integers);
        System.out.println("反转后的integers = " + integers);
//        实现两个元素的位置交换
        Collections.swap(integers, 0,3);
        System.out.println("元素交换后integers = " + integers);

//        实现元素的排序
        Collections.sort(integers);
        System.out.println("排序后integers = " + integers);

//        实现随机置换
        Collections.shuffle(integers);
        System.out.println("随机置换后integers = " + integers);

//        List<Integer> l2 = new ArrayList<>(20);
        List<Integer> l2 = Arrays.asList(new Integer[integers.size()]);
        Collections.copy(l2, integers);
        System.out.println("l2 = " + l2);

    }
}
