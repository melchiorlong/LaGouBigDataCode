package com.study.Stage1.Section2.Animal;

public class Animal {

    private String name;
    private String color;

    public Animal() {
    }

    public Animal(String name, String color) {
        setColor(color);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void show(){
        System.out.println("名称" + name);
        System.out.println("颜色" + color);
    }

}
