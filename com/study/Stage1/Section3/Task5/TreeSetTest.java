package com.study.Stage1.Section3.Task5;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

//        准备一个比较器对象，作为参数传递给构造方法
//        使用匿名内部类
//        接口/父类类型 引用变量名 = new 接口/父类类型() {方法的重写};
//        Comparator<Student> comparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) { // o1表示新增加的对象，o2表示集合中已经有的
////                return 0;
//            return o1.getAge() - o2.getAge();  // 排序写法类似重写Comparable
//
//            }
//        };

//        从Java8开始支持lambda表达式
//        (参数列表) -> {方法体};

//        Comparator<Student> comparator = (Student o1,Student o2) -> {return o1.getAge() - o2.getAge(); };

        Comparator<Student> comparator = Comparator.comparing(Student::getName);


        Set<Student> s2 = new TreeSet<>(comparator);
        s2.add(new Student("zhangfei", 18));
        s2.add(new Student("liubei", 20));
        s2.add(new Student("guanyu", 30));

        System.out.println("s2 = " + s2);





    }
}
