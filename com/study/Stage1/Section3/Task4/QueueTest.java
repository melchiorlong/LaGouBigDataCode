package com.study.Stage1.Section3.Task4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {
        /**
         * 准备一个Queue集合，将数据11、22、33、44、55依次入队并打印，然后查看队首元素并打印，
         * 然后将队列中所有数据依次出队并打印。
         */

        Queue q1 = new LinkedList();
        for (int i = 1; i <= 5; i++) {
            boolean offer = q1.offer(i * 11);
            System.out.println("队列中的元素有：" + q1);
        }

        System.out.println("------------------------------------------------");
        System.out.println("队首元素是： " + q1.peek());

        System.out.println("------------------------------------------------");
        int size = q1.size();
        for (int i = 1; i <= size; i++) {
            Object poll = q1.poll();
            System.out.println("出列的元素是：" + poll);
        }

        System.out.println("------------------------------------------------");
        System.out.println("队列中的元素有：" + q1);


    }

}
