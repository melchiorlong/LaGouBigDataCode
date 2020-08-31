package com.homework.Stage1.Section1;

import java.util.Scanner;

public class Day_In_Year_Calculate {

//    提示用户输入年月日信息，判断这一天是这一年中的第几天并打印。
// 解题思路
// 1、接收输入年月日
// 2、根据年判断是否闰年
// 3、根据case穿透的特性计算日合计数
// 4、将30天，31天的月统计出来
// 5、计算逻辑：days为输入日，非1月计算所有T-1月日合计，再加输入日


    public static void main(String[] args) {
        // 获取输入年月日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年");
        int year = sc.nextInt();
        System.out.println("请输入月");
        int month = sc.nextInt();
        System.out.println("请输入日");
        int day = sc.nextInt();
        // 调计算方法
        int day_sum = calculate(year, month, day);
        // 输出
        System.out.println("这是这一年中第" + day_sum + "天。");
    }

    //  判断是否闰年
    public static boolean is_leap(int year) {
        // 声明变量
        boolean isLeap = true;
        // 判断是否闰年
        if (year % 100 == 0) {
            isLeap = year % 400 == 0;
        } else {
            isLeap = year % 4 == 0;
        }
        return isLeap;
    }

    //  计算合计日
    public static int calculate(int year, int month, int days) {
//  每月几天
//  31天     ---1、3、5、7、8、10、12
//  30天     ---4、6、9、11
//  28or29天 ---2
        // 获取是否闰年
        boolean isLeap = is_leap(year);
        // 声明4种月的日期数及合计值
        int days_31 = 31;
        int days_30 = 30;
        int days_28 = 28;
        int days_29 = 29;
        int day_sum = 0;
        // 开始计算，因需要使用case穿透，所以不加break;
        switch (month) {
            // 同理
            case 12:
                day_sum += days_30;
                // 同理
            case 11:
                day_sum += days_31;
                // 同理
            case 10:
                day_sum += days_30;
                // 同理
            case 9:
                day_sum += days_31;
                // 同理
            case 8:
                day_sum += days_31;
                // 同理
            case 7:
                day_sum += days_30;
                // 同理
            case 6:
                day_sum += days_31;
                // 同理
            case 5:
                day_sum += days_30;
                // 当输入2月时，合计数等于4月数+3月+2月+输入日
            case 4:
                day_sum += days_31;
                // 当输入3月时，合计数等于1月数+2月数+输入日，其中2月数根据是否闰年判断，闰年+29，非闰年+28
            case 3:
                if (isLeap) {
                    day_sum += days_29;
                } else {
                    day_sum += days_28;
                }
                // 当输入2月时，合计数等于1月数+输入日
            case 2:
                day_sum += days_31;
                // 当输入1月时，直接取输入日为日期数
            case 1:
                day_sum += days;
        }
        // 返回
        return day_sum;
    }
}
