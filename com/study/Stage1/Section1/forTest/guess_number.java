package com.study.Stage1.Section1.forTest;

import java.util.Random;
import java.util.Scanner;

public class guess_number {

    public static void main(String[] args) {

        Random rn_temp = new Random();
        int rn = rn_temp.nextInt(100) + 1;
        int count = 0;
        for (; ; ) {
            count++;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个1-100之间的数字。");
            int guess = sc.nextInt();
            if (guess - rn < 0) {
                System.out.println("猜小了");
            } else if (guess - rn > 0) {
                System.out.println("猜大了");
            } else {
                System.out.println("Bingo！");
                System.out.println("猜了" + count + "次");
                if(count == 1){
                    System.out.println("A级");
                }else if(1<count && count <6){
                    System.out.println("B级");
                }else{
                    System.out.println("C级");
                }
                break;
            }
        }
    }
}
