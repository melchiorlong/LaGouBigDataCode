package com.study.Stage1.Section1.arrayTest;

public class TwoD_array {

    public static void main(String[] args) {

//        声明一个2行列的int二维数组

        int[][] arr1 = new int[2][3];
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------");

        int num = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = num++;
            }
        }
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
