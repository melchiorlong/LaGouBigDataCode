package com.study.Stage1.Section1.forTest;

public class nine_multipy_nine {
    public static void main(String[] args) {

        outer : for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
//            if (i == 6){
//                break outer;
//            }
        }
    }
}
