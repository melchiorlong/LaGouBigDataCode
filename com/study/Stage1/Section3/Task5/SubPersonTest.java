package com.study.Stage1.Section3.Task5;

public class SubPersonTest {

    public static void main(String[] args) {

        SubPerson<Boolean, String> sp1 = new SubPerson<>();
        sp1.setAge(18);
        sp1.setGender(true);
        sp1.setName("张飞");
        System.out.println("sp1 = " + sp1);
    }

}
