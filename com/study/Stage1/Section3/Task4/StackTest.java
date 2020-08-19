package com.study.Stage1.Section3.Task4;

import java.util.Stack;

public class StackTest {



    public static void main(String[] args) {

        /**
         * 准备一个Stack集合，将数据11、22、33、44、55依次入栈并打印，然后查看栈顶元素并打印，
         * 然后将栈中所有数据依次出栈并打印。
         * 再准备一个Stack对象，将数据从第一个栈中取出来放入第二个栈中，然后再从第二个栈中取出并
         * 打印。
         */

        Stack s1 = new Stack();
        Stack s2 = new Stack();
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        for (int i = 1; i <= 5; i++) {
            Object obj = s1.push(i * 11);
//            System.out.println("入栈的元素是： " + obj);
            System.out.println("栈中元素是：" + s1);
        }

        System.out.println("-------------------------------------------");

        Object peek = s1.peek();
        System.out.println("栈顶元素是：" + peek);

        int size = s1.size();
        for (int i = 0; i < size; i++) {
            Object pop = s1.pop();
            s2.push(pop);

            System.out.println("s1栈中元素是：" + s1);
        }
        System.out.println("s2栈中元素是：" + s2);

        System.out.println("-------------------------------------------");

        size = s2.size();
        for (int i = 0; i < size; i++) {
            s2.pop();
            System.out.println("s2栈中元素是：" + s2);
        }










    }

}
