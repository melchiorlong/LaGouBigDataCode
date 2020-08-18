package com.study.Stage1.Section3.Task2;

import java.util.Scanner;

public class StringEqualsTest {

//    1、提示用户输入用户名和密码信息
//    2、判断用户名和密码是否为"admin" 和 "123456" 并提示

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名和密码。");
            String user = sc.next();
            String pass = sc.next();
            if (user.equalsIgnoreCase("admin") && pass.equals("123456")) {
                System.out.println("欢迎");
                break;
            } else {
                System.out.println(i == 2 ? "用户已经冻结。" : "用户名或密码错误，请重试，您还有" + (2 - i) + "次机会！");
            }
        }
        sc.close();
    }
}
