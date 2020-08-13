package com.study.Stage1.Section2.Task5.StaticOuter;

public class StaticOuterTest {

    public static void main(String[] args) {

        // 声明StaticInner类型的引用
        StaticOuter.StaticInner si = new StaticOuter.StaticInner();
        si.show();
        System.out.println("------------------------------------------------------------------------------");
        si.show2(5);

    }
}
