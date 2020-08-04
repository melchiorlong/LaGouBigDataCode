package com.homework.Stage1.Section1;

import static java.lang.Math.sqrt;

public class Finished_Num {

//    编程找出1000以内的所有完数并打印出来。
//    所谓完数就是一个数恰好等于它的因子之和 如 6=1+2+3
// 解题思路
// 1、首先遍历1-1000整数
// 2、内层循环找到因子，并求和
// 3、外层循环中判断若因子合=遍历数，则打印

    public static void main(String[] args) {
        // 遍历1-1000正整数
        for (int i = 1; i < 1000; i++) {
            // 声明合计变量以临时存储合计数
            int sum_temp = 0;
            // 内层循环找因子
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    // 因子求和
                    sum_temp += j;
                }
            }
            // 判断是否因子合=遍历数
            if (i == sum_temp) {
                // 输出
                System.out.println(i + "是完数");
            }
        }
    }
}

