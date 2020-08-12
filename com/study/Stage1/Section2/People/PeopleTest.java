package com.study.Stage1.Section2.People;

public class PeopleTest {

    public static void main(String[] args) {
        People p1 = new People();
        p1.setName("张三");
        p1.setAge(18);
        p1.setNationality("中国");
        p1.show();

        System.out.println("--------------------------------------------------");

        People p2 = new People("李四", 20);
        p2.show();

        System.out.println("--------------------------------------------------");

        People p3 = new People("王五", 22);
        People.nationality = "美国";
        p3.show();
        p2.show();
    }
}
