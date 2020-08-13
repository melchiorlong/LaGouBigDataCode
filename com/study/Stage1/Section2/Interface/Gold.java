package com.study.Stage1.Section2.Interface;

public class Gold implements Metal, Money{

    @Override
    public void Shine() {
        System.out.println("发光");

    }

    @Override
    public void Buy() {
        System.out.println("买东西");
    }


    public static void main(String[] args) {
        Metal mt = new Gold();
        mt.Shine();
        Money mn = new Gold();
        mn.Buy();

    }
}
