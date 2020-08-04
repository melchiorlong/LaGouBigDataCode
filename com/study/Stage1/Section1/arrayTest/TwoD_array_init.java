package com.study.Stage1.Section1.arrayTest;

public class TwoD_array_init {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] ints: arr1
             ) {
            for (int i: ints
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }
}
