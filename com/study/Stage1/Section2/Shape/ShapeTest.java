package com.study.Stage1.Section2.Shape;

public class ShapeTest {

//    自定义成员方法实现将参数指定矩形对象特征打印出来，绘制图形的行为

//    private static void draw(Rect rect){
//        rect.show();
//    }
//
////    自定义成员方法，实现将参数指定圆形对象特诊的打印
//
//    public static void draw(Circle circle){
//        circle.show();
//    }

//    自定义成员方法实现既能打印矩形，又能打印圆形对象特征，对象由参数传入
    public static void draw(Shape shape){
        shape.show();
    }




    public static void main(String[] args) {

        Rect rect = new Rect(1,2,3,4);
        draw(rect);
        System.out.println("------------------------------------------------------------------");
        Circle circle = new Circle(5,6,7);
        draw(circle);
        System.out.println("------------------------------------------------------------------");
        Shape shape1 = new Rect(11,22,33,44);
        draw(shape1);
        System.out.println("------------------------------------------------------------------");
        Shape shape2 = new Circle(55,66,77);
        draw(shape2);
//        System.out.println("------------------------------------------------------------------");
//        Shape shape3 = new Rect(55,66,77,88);
//        draw(shape3);

    }

}
