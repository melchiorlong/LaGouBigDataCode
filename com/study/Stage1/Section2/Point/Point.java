package com.study.Stage1.Section2.Point;

public class Point {

    int x;
    int y;

    public static void main(String[] args) {
        Point p = new Point();
        System.out.println("横坐标是" + p.x + "纵坐标是" + p.y);
        System.out.println("----------------------------------------------------------------------------------");

        p.x = 5;
        p.y = 3;
        System.out.println("横坐标是" + p.x + "纵坐标是" + p.y);
    }
}
