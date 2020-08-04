package com.homework.Stage1.Section1;

import java.util.Arrays;
import java.util.Random;

public class Random_Num {

//    实现双色球抽奖游戏
//    中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
//    其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
//    其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
// 解题思路
// 1、蓝球红球分开取，其中蓝球只取一个，直接取随机数即可。红球需要去重
// 2、去重方法可先任取后，循环遍历数组中元素，若重复更新重复元素，此方法效率低，放弃。
// 3、通过声明一个32个元素的布尔数组，将1-32作为数组下标，取过后更新元素值为真，循环判断取值即可。
// 4、通过dowhile循环可实现。do块中循环给index赋随机数，while判断该随机数是否在布尔数组中已经存在。若存在重新给index随机数，若不存在赋值到目标数组中。
// 5、声明布尔数组后因默认为所有元素为false，所以当更新随机数后，将该index的元素值更新为true，循环判断即可。
//


    public static void main(String[] args) {
        // 声明随机数
        Random rm = new Random();
        // 声明目标数组
        int[] serial = new int[7];
        // 将最后一个元素（蓝球）任取1-16件随机数
        serial[6] = rm.nextInt(15) + 1;
        // 声明一个长32的Boolean数组
        boolean[] bool = new boolean[32];
        // 声明一个数作为index
        int random_index = 0;
        // 开始循环
        for (int i = 0; i < serial.length - 1; i++) {
            do {
                // 将随机数赋值给index
                random_index = rm.nextInt(32) + 1;
            }
            // 判断布尔数组中该index值是否为false
            while (bool[random_index]);
            // 更新值为true
            bool[random_index] = true;
            // 将随机数更新至目标数组中
            serial[i] = random_index;
        }
        // 输出
        System.out.println(Arrays.toString(serial));
    }
}
