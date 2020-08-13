package com.study.Stage1.Section2.Task5.AreaOuter;

/**
 * 编程实现局部内部类的定义和使用
 */
public class AreaOuter {

    private int cnt = 1;


    public void show() {

        final int[] ic = {4};


        // 定义局部内部类，只在当前方法体的内部
        class AreaInner {
            private int ia = 2;

            public AreaInner() {
                System.out.println("局部内部类的构造方法");
            }

            public void test() {
                System.out.println("ia = " + ia);
                System.out.println("cnt = " + cnt);
                ic[0] = 5;
                System.out.println("内部ic = " + ic[0]);
            }
        }
        AreaInner ai = new AreaInner();
        ai.test();
        System.out.println("外部ic = " + ic[0]);
    }
}
