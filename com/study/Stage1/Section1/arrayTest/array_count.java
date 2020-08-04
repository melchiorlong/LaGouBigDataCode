package com.study.Stage1.Section1.arrayTest;

import java.util.Scanner;

public class array_count {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int number = sc.nextInt();
        int temp = number;
        int[] arr1 = new int[10];

        while (temp > 0) {
            arr1[temp % 10]++;
            temp /= 10;
        }

        for (int i = 0; i < arr1.length; i++
        ) {
            if (arr1[i] > 0) {
                System.out.println("数字" + number + "中" + i + "出现了" + arr1[i] + "次。");
            }
        }
    }
}
