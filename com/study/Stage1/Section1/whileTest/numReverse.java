package com.study.Stage1.Section1.whileTest;

import java.util.Scanner;

public class numReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num = sc.nextInt();
        int temp = num;
        while (num > 0) {
            System.out.print(num % 10);
            num = num / 10;
        }
        System.out.println("---------------------------------------------");

        int res_num = 0;
        while (temp > 0){
            res_num = res_num * 10 + temp % 10;
            temp = temp / 10;
        }
        System.out.println("res = " + res_num);
    }
}
