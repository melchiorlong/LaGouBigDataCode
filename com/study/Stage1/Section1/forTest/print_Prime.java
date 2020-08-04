package com.study.Stage1.Section1.forTest;

import static java.lang.StrictMath.sqrt;

public class print_Prime {
    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {
            boolean flag = true;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("i = " + i);
            }
        }
    }
}
