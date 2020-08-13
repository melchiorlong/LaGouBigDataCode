package com.study.Stage1.Section2.Task5.StaticOuter;

/**
 * 实现静态内部类的定义和使用
 */
public class StaticOuter {

    private int cnt = 1;
    private static int snt = 2;

    public void show(){
        System.out.println("外部类的show方法");
    }




    public static class StaticInner{
        private int ia = 3;
        private static int snt = 4;

        public StaticInner(){
            System.out.println("静态内部类的构造方法");
        }
        public void show(){
            System.out.println("ia = " + ia);
            System.out.println("外部类中的snt是" + snt);
//            System.out.println("外部类中的cnt是" + cnt);
            // 静态上下文中不能访问费静态成员，可能此时没有创建对象
        }

        public void show2(int snt){
            System.out.println("snt = " + snt);
            System.out.println("内部类中的snt = " + StaticInner.snt);
            System.out.println("外部类中的snt = " + StaticOuter.snt);
            new StaticOuter().show();
        }

    }


}
