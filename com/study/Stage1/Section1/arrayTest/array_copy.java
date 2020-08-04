package com.study.Stage1.Section1.arrayTest;

public class array_copy {

    public static void main(String[] args) {

        /* 声明一个初始值为11 22 33 44 55 的一维数组并打印
         *  声明一个长度为3的元素类型为int 的一维数组并打印
         * 实现将第一个数组中间3个元素赋值到第二个数组中
         * 再次打印第二个数组 */

        int[] arr1 = new int[]{11, 22, 33, 44, 55};
        for (int i : arr1
        ) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------------------------");

        int[] arr2 = new int[3];
        for (int i : arr2
        ) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------------------------");

        System.arraycopy(arr1, 1, arr2, 0, 3);
        for (int i : arr2
        ) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------------------------");

        arr2 = arr1;
        for (int i : arr2
             ) {
            System.out.println(i);
        }
    }
}
