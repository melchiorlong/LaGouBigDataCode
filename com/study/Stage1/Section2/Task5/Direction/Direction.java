package com.study.Stage1.Section2.Task5.Direction;

/**
 * 编程实现所有方向的枚举：上 下 左 右
 */
public class Direction {

    private final String desc;

    public static final Direction UP = new Direction("上");
    public static final Direction DOWN = new Direction("下");
    public static final Direction LEFT = new Direction("左");
    public static final Direction RIGHT = new Direction("右");

    private Direction(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
