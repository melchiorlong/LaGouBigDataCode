package com.study.Stage1.Section3.Task2;

public class IsHuiWen {

    public static void main(String[] args) {

//        1、创建字符串对象并打印
//        2、判断是否是回文并打印

        String str1 = new String("上海自来水来自海上");
        System.out.println("str1 = " + str1);

        for (int i = 0; i < str1.length() / 2; i++) {
            if (str1.charAt(i) != str1.charAt(str1.length() - 1 - i)) {
                System.out.println("不是回文");
                return;
            }
        }
        System.out.println("是回文");
    }
}
