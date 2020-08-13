package com.study.Stage1.Section2.Task5.InnerOuter;

/**
 * 编程实现内部类的实现和使用
 */

public class NormalOuter {

    private int cnt = 1;

    //    定义普通内部类
    public final class NormalInner{
        private int i1 =2;

        private int cnt = 3;
        public NormalInner(){
            System.out.println("普通内部类的构造方法");
        }

        public void show(){
            System.out.println("外部类中的变量cnt是" + cnt);
            System.out.println("内部类汇总的白能量i1是" + i1);
        }

        public void show2(int cnt){
            System.out.println("形参cnt变量是" + cnt);
            System.out.println("内部类cnt变量是" + this.cnt);
            System.out.println("外部类cnt变量是" + NormalOuter.this.cnt);
        }
    }



}
