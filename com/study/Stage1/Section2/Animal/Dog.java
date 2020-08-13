package com.study.Stage1.Section2.Animal;

public class Dog extends Animal {

    private int teeth;
    public int getTeeth() {
        return teeth;
    }

    public void setTeeth(int teeth) {
        if (teeth > 0) {
            this.teeth = teeth;
        } else {
            System.out.println("牙齿数量错误");
        }
    }

    public Dog() {
    }

    public Dog(String name, String color, int teeth) {
        super(name, color);
        setTeeth(teeth);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("牙齿数量" + teeth);
    }
}
