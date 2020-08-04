package com.study.Stage1.Section1.arrayTest;

public class array_operation {
    public static void main(String[] args) {

//        声明一个长度为5 类型为int的一维数组，打印所有元素值
//        使用元素 11 22 33 44 分别对数组中前四个元素复制后打印
//        将元素55插入到下表为0的位置，所有元素向后移动 在打印
//        将元素55从数组中删除,删除方式为后续元素向前移动 最后位置为0 在打印
//        查找数组中是否存在元素22 若存在则修改为220后,打印

        int[] arr1 = new int[5];
        for (int i: arr1
        ) {
            System.out.println(i);
        }

        System.out.println("长度 = " + arr1.length);
        System.out.println("----------------------------------------------------------------------------------------");

        for (int i = 0; i < 4; i++) {
            arr1[i] = (i+1)*11;
        }

        for (int i: arr1
             ) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------------------------------------------");

        for (int i = arr1.length -1; i>0; i--) {
            arr1[i] = arr1[i-1];
        }
        arr1[0] = 55;
        for (int i: arr1
        ) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------------------------------------------");

        for (int i = 0; i < arr1.length - 1; i++) {
            arr1[i] = arr1[i+1];
        }
        arr1[4] = 0;

        for (int i: arr1
             ) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------------------------------------------");

        for (int i = 0; i < arr1.length - 1; i++) {
            if (22 == arr1[i]){
                arr1[i] = 220;
            }
        }

        for (int i : arr1
             ) {
            System.out.println(i);
        }
    }
}
