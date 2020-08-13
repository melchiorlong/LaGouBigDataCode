package com.study.Stage1.Section2.Task5.Direction;

/**
 * 编程实现所有方向的枚举：上 下 左 右
 */
public enum DirectionEnum implements DirectionInterface{
    UP("上"){
        @Override
        public void show() {
            System.out.println("贪吃蛇向上移动了一下");
        }
    },
    DOWN("下") {
        @Override
        public void show() {
            System.out.println("贪吃蛇向下移动了一下");
        }
    },
    LEFT("左") {
        @Override
        public void show() {
            System.out.println("贪吃蛇向左移动了一下");
        }
    },
    RIGHT("右") {
        @Override
        public void show() {
            System.out.println("贪吃蛇向右移动了一下");
        }
    };

    private final String desc;


    private DirectionEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    // 整体重写show方法
//    @Override
//    public void show() {
//        System.out.println("实现接口show方法");
//    }



}
