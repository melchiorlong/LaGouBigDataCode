package com.study.Stage1.Section2.Task5.AnonymousInterface;

public class AnonymousInterfaceTest {

    public static void test(AnonymousInterface anonymousinterface){
        anonymousinterface.show();
    }

    public static void main(String[] args) {

        AnonymousInterfaceTest.test(new AnonymousInterfaceImpl());

        System.out.println("------------------------------------------------------------------");
//        使用匿名内部类的语法格式得到接口类型的引用

        AnonymousInterface ai = new AnonymousInterface(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };

        // 从Java8开始，可以使用lambda表达式

        AnonymousInterface ai1 = () -> System.out.println("lambda表达式");
        AnonymousInterfaceTest.test(ai);
        AnonymousInterfaceTest.test(ai1);
    }
}
