package com.study.Stage1.Section2.Shape;

public class ShapeRectTest {

    public static void main(String[] args) {

        Shape shape1 = new Shape(1,2);
        shape1.show();

        System.out.println("-------------------------------------------------------------------------------");

        Rect rect1 = new Rect(3, 4,5,6);
        rect1.show();

        System.out.println("-------------------------------------------------------------------------------");

        Shape shape2 = new Rect(7,8,9,10);
        shape2.show();

        System.out.println("-------------------------------------------------------------------------------");

        int ax = shape2.getX();
        int ay = shape2.getY();
        System.out.println("获取到的横纵坐标是" + ax + "," + ay);

        Rect.test();
        Shape.test();

        System.out.println("-------------------------------------------------------------------------------");

//        调用子类独有的方法
        int bx = ((Rect) shape2).getWidth();
        int by = ((Rect) shape2).getLength();
        System.out.println("调用子类独有方法获取的长度和宽度分别是" + by + "," + bx);

//        强转前用 instanceof 进行类型判断
        if (shape2 instanceof Circle){
            System.out.println("可以强转");
        }else {
            System.out.println("不能强转");
        }


    }
}
