package com.study.Stage1.Section1.arrayTest;

import java.util.Arrays;

public class arrayTools {
    public static void main(String[] args) {
//        声明一个初始值为10， 20 ，30，40,50 的一维数组
//        使用原始方法打印数组中的元素 要求打印格式为[10, 20, 30, 40, 50]
//        使用数组工具类实现数组中所有元素的打印

        int[] arr1 = {2, 4, 77, 1, 1};
        System.out.print("[");
        for (int i = 0; i < arr1.length; i++) {
            if (i != arr1.length - 1) {
                System.out.print(arr1[i] + ", ");
            } else {
                System.out.print(arr1[i] + "]");
            }
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");

        System.out.println(Arrays.toString(arr1));

        System.out.println("----------------------------------------------------------------");

        int[] arr2 = new int[5];
        Arrays.fill(arr2, 10);
        System.out.println(Arrays.toString(arr2));

        System.out.println("----------------------------------------------------------------");

//        Arrays.equals(arr1, arr2);
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println("----------------------------------------------------------------");

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }
}
