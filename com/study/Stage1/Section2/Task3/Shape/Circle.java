package com.study.Stage1.Section2.Task3.Shape;

public class Circle extends Shape{

    private int r;

    public Circle() {
    }

    public Circle(int x, int y, int r) {
        super(x, y);
        setR(r);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        if (r > 0) {
            this.r = r;
        }else{
            System.out.println("半径错误");
        }
    }

    @Override
    public void show() {
        super.show();
        System.out.println("半径是" + getR());
    }
}
