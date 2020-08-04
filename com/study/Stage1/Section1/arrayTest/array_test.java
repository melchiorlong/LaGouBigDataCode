package com.study.Stage1.Section1.arrayTest;

public class array_test {
    public static void main(String[] args) {

        int[] arr1 = new int[2];
        String[] arr2 = new String[]{"123","歇息"};
        arr1[0] = 1212;
        arr1[1] = 12;

        System.out.println(arr1.length);
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        for (int i: arr1
             ) {
            System.out.println("arr1 = " + i);
        }

        for (String str: arr2
             ) {
            System.out.println("str = " + str);
        }
    }
}
