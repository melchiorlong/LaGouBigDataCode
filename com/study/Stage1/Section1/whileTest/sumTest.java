package com.study.Stage1.Section1.whileTest;

import java.util.Scanner;

public class sumTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double sum = 0.0;
        int i = 1;
        while (i <= num){
            sum += 1.0 / i ;
            i++;
        }
        System.out.println(sum);
    }
}
