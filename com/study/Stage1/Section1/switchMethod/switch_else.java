package com.study.Stage1.Section1.switchMethod;

import java.util.Scanner;

public class switch_else {

    public static void main(String[] args) {

        System.out.println("请输入考试成绩");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        int rank = score / 10;

        switch(rank){
            case 10:
            case 9:
                System.out.println("等级A");break;
            case 8:
                System.out.println("等级B");break;
            case 7:
                System.out.println("等级C");break;
            case 6:
                System.out.println("等级D");break;
            default:
                System.out.println("等级E");
        }
    }
}
