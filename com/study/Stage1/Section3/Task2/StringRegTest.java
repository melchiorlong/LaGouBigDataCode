package com.study.Stage1.Section3.Task2;

import java.util.Scanner;

public class StringRegTest {

    public static void main(String[] args) {

//        1、定义描述规则的正则表达式，并使用变量记录
//        描述银行卡密码的规则，由6位数字组成
//        2、提示用户输入并记录
//        3、判断用户输入是否符合正则表达式


        Scanner sc = new Scanner(System.in);
//        String reg = "^\\d{6}$";
//        1、QQ号的正则表达式
//        String reg = "[1-9]\\d{4,14}";
//        2、手机号的正则表达式
//        String reg = "1[34578]\\d{9}";
//        3、身份证号的正则表达式
        String reg = "";


        while (true) {
            System.out.println("请输入");
            String pass = sc.next();
            if (pass.matches(reg)) {
                System.out.println("正确");
            } else {
                System.out.println("错误");
            }
        }
    }
}
