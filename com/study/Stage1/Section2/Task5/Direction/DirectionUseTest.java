package com.study.Stage1.Section2.Task5.Direction;

public class DirectionUseTest {

    // 自定义静态方法实现根据参数指定的字符串内容打印具体的方向信息

    public static void test1(String str){
        switch (str) {
            case "上":
                System.out.println("举头望明月");break;
            case "下":
                System.out.println("低头思故乡");break;
            case "左":
                System.out.println("左牵黄");break;
            case "右":
                System.out.println("右擎苍");break;
            default:
                System.out.println("方向错误");
        }
    }

    public static void test2(DirectionEnum directionEnum){
        switch (directionEnum) {
            case UP:
                System.out.println("举头望明月");break;
            case DOWN:
                System.out.println("低头思故乡");break;
            case LEFT:
                System.out.println("左牵黄");break;
            case RIGHT:
                System.out.println("右擎苍");break;
            default:
                System.out.println("方向错误");
        }
    }


    public static void main(String[] args) {

        DirectionUseTest.test1(DirectionEnum.UP.getDesc());
        DirectionUseTest.test2(DirectionEnum.DOWN);

    }

}
