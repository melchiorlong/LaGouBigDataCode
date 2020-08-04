package com.study.Stage1.Section1.arrayTest;

import java.util.Scanner;

public class YangHui_Triangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入行数");
        int rows = sc.nextInt();

        int[][] tri = new int[rows][];

        for (int i = 0; i < rows; i++) {
            tri[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    tri[i][j] = 1;
                } else {
                    tri[i][j] = tri[i - 1][j] + tri[i - 1][j - 1];
                }
            }
        }

        for (int[] ints : tri
        ) {
            for (int i : ints
            ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
