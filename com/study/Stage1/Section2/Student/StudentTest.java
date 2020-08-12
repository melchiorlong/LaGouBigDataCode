package com.study.Stage1.Section2.Student;

import java.util.Scanner;

/*
 * 变成实现学生信息的输入和打印
 * */

public class StudentTest {

    public static void main(String[] args) {
        System.out.println("请输入学生人数: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Student[] arr1 = new Student[num];

        for (int i = 0; i < num; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的信息（学号 姓名）");
            arr1[i] = new Student(sc.nextInt(), sc.next());
        }

        System.out.println("该班级所有人员信息");
        for (Student student : arr1) {
//            System.out.println(student.getId() + student.getName());
            student.show();
        }

    }


}
