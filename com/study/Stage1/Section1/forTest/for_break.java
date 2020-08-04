package com.study.Stage1.Section1.forTest;

import java.util.Scanner;

public class for_break {

    public static void main(String[] args) {

        boolean flag = true;
        for(;;){
            System.out.println("请" + (flag?"张三":"李四") + "输入内容：");
            Scanner sc = new Scanner(System.in);
            String word = sc.next();
            if (word.equals("bye")){
                System.out.println("再见");
                break;
            }
            System.out.println("输入的内容是：" + word);
            flag = !flag;
        }
    }
}
