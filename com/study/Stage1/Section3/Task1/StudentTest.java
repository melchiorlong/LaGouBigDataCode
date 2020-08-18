package com.study.Stage1.Section3.Task1;

public class StudentTest {

    public static void main(String[] args) {

//        使用有参方式构造
        Student s1 = new Student(1001, "zhangfei");
        Student s2 = new Student(1001, "zhangfei");


        System.out.println(s1.equals(s2));
        s2.setId(1001);
        System.out.println(s1.equals(s2));
        System.out.println("------------------------------------");
        s1.show();
        s2.show();

        System.out.println("===========================================================================");

//        调用Object中的hashcode

        int hashcode_s1 = s1.hashCode();
        int hashcode_s2 = s2.hashCode();
        System.out.println(hashcode_s1);
        System.out.println(hashcode_s2);

        System.out.println("===========================================================================");

        System.out.println(hashcode_s1);
        String string_s1 = s1.toString();
        System.out.println(string_s1);



    }

}
