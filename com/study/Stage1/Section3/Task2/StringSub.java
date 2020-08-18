package com.study.Stage1.Section3.Task2;

import java.util.Scanner;

public class StringSub {

//    提示用户输入一个字符串和一个字符，输入该字符后（不包含该字符）后面的所有字符串

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户输入一个字符串和一个字符");
        String strAll = sc.next();
        String str = sc.next();
        System.out.println(strAll.contains(str) ? strAll.substring(strAll.indexOf(str) + 1) : "输入错误");
    }
}
