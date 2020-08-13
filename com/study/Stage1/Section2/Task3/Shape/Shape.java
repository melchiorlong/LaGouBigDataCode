package com.study.Stage1.Section2.Task3.Shape;

public class Shape {

    private int x;
    private int y;

    public Shape() {
    }

    public Shape(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void show(){
        System.out.println("横坐标是" + x);
        System.out.println("纵坐标是" + y);
    }

    public static void test(){
        System.out.println("Shape中静态方法");
    }

}
