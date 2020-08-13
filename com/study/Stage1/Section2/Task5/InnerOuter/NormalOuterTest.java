package com.study.Stage1.Section2.Task5.InnerOuter;

public class NormalOuterTest {

    public static void main(String[] args) {
        // 声明内部类的引用指向内部类的对象
        // 调用内部类中的show()方法

        NormalOuter no = new NormalOuter();
        NormalOuter.NormalInner ni = no.new NormalInner();

        ni.show();
        ni.show2(4);
    }
}
