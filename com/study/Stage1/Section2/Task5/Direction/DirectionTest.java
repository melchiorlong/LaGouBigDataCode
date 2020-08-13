package com.study.Stage1.Section2.Task5.Direction;

public class DirectionTest {

    public static void main(String[] args) {

//        Direction direction = new Direction("上");

        Direction up = Direction.UP;
        Direction down = Direction.DOWN;
        Direction left = Direction.LEFT;
        Direction right = Direction.RIGHT;

        System.out.println("获取到的字符串是:" + up.getDesc());
        System.out.println("获取到的字符串是:" + down.getDesc());
        System.out.println("获取到的字符串是:" + left.getDesc());
        System.out.println("获取到的字符串是:" + right.getDesc());

        DirectionEnum d1 = DirectionEnum.UP;
        System.out.println("枚举类的上是：" + d1.getDesc());

        DirectionEnum[] directionEnums = DirectionEnum.values();

        for (int i = 0; i < directionEnums.length; i++) {
            directionEnums[i].show();
        }


    }
}
