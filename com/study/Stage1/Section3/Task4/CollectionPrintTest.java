package com.study.Stage1.Section3.Task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionPrintTest {

    public static void main(String[] args) {

//        准备一个集合，并放入元素

        Collection c1 = new ArrayList();
        c1.add("one");
        c1.add(2);
        c1.add(new Person("zhangfei", 30));

        System.out.println("c1 = " + c1);

//      使用迭代器遍历结合中的所有元素
//        1. 获取当前集合的迭代器
        Iterator iterator = c1.iterator();
//        2. 判断是否有元素可以访问
        System.out.println(iterator.hasNext());
//        3. 取出一个元素，然后指向下一个
//        System.out.println("获取到的元素是： " + iterator.next());
//        4. 遍历所有

        while (iterator.hasNext()) {
            System.out.println("遍历迭代器中，获取到的元素： " + iterator.next());
        }


        System.out.println("----------------------------------------------------");

//        [one, 2, Person{name='zhangfei', age=30}]

        iterator = c1.iterator();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (!iterator.hasNext()) {
                sb1.append(next).append("]");
            } else {
                sb1.append(next).append(", ");
            }
        }
        System.out.println("sb1 = " + sb1);

        System.out.println("----------------------------------------------------");

        iterator = c1.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next == "one") {
                iterator.remove();
            }
        }
        System.out.println("删除后集合中元素：" + c1);

        System.out.println("----------------------------------------------------");

        c1.add("new one");

        for (Object obj : c1
        ) {
            System.out.println(obj);
        }


    }

}
