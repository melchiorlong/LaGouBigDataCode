package com.homework.Stage1.Section1;

import java.util.Arrays;

public class Array_Expansion {

//    自定义数组扩容规则，当已存储元素数量达到总容量的80%时，扩容1.5倍。
//    例如，总容量是10 ，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15 。

// 解题思路
// 1、判断原数组中非默认元素是否达到数组容量的80%
// 2、若达到，则新增临时数组扩容至原数组的1.5倍长度
// 3、将原数组数据复制到临时数组中
// 4、临时数组地址赋值给原数组，并释放临时数组

    public static void main(String[] args) {

        // 初始化一个长10的int数组
        int[] num_ori = new int[10];
        // 插入实例元素
        for (int i = 0; i < 10; i++) {
            num_ori[i] = i;
        }
        // 调用扩容方法
        array_expansion(num_ori);
    }

    public static void array_expansion(int[] num_ori) {
        // 新增计数
        int count = 0;
        // 遍历数组，统计非默认元素个数
        for (int i : num_ori
        ) {
            if (i != 0) {
                count++;
            }
        }
        // 判断非默认元素是否大于80%
        if (count % num_ori.length >= 8) {
            // 新增临时数组 arr_temp，长度为原数组的1.5倍
            int[] arr_temp = new int[(int) (1.5 * num_ori.length)];
            // 将原数组复制到临时数组中
            System.arraycopy(num_ori, 0, arr_temp, 0, num_ori.length);
            // 将临时数组地址赋值给原数组，临时数组自动释放
            num_ori = arr_temp;
        }
        // 修改与否，打印原数组
        System.out.println(Arrays.toString(num_ori));
    }
}
