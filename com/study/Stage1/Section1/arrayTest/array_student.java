package com.study.Stage1.Section1.arrayTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class array_student {

    public static void main(String[] args) {

/*提示用户输入学生的人数，以及每个学生的考试成绩 并打印
* 计算班级总分和平均分并打印*/

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生人数");
        int student_num = sc.nextInt();
        double score_sum = 0.0;
        double[] score = new double[student_num];

        for (int i = 0; i < student_num; i++) {
            System.out.println("请输入学生" + (i+1) + "成绩");
            score[i] = sc.nextInt();
        }
        for (double i : score
             ) {
            System.out.print("学生成绩分别是" + i + "  ");
        }

        for (int i = 0; i < student_num; i++) {
            score_sum += score[i];
        }
        double avg = score_sum / student_num;
        BigDecimal big_avg = new BigDecimal(avg);
        System.out.println("平均分为" + big_avg.setScale(2, RoundingMode.HALF_UP).toString());
    }
}
