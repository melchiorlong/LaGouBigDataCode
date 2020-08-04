package com.study.Stage1.Section1.switchMethod;

import java.util.Scanner;

public class menuTest {

    public static void main(String[] args) {

        System.out.println("         欢迎来到进入系统         ");
        System.out.println("-------------------------------");
        System.out.print("[1]学员系统          ");
        System.out.println("[2]管理员系统");
        System.out.println("[0]退出系统");
        System.out.println("-------------------------------");
        System.out.println("请选择要进入的系统");

        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();

        switch (choose){
            case 1:
                System.out.println("正在进入学员系统....");break;
            case 2:
                System.out.println("正在进入管理员系统....");break;
            case 0:
                System.out.println("再见！");break;
            default:
                System.out.println("请重新输入！");
        }
    }
}
