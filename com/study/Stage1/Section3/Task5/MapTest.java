package com.study.Stage1.Section3.Task5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

//        准备一个Map 然后打印
        Map<String, String> map = new HashMap<>();
        String one = map.put("1", "one");
        System.out.println("map = " + map);
        String two = map.put("2", "two");
        System.out.println("map = " + map);
        String t_w_o = map.put("2", "t w o");
        System.out.println("map = " + map);
        String three = map.put("3", "three");
        System.out.println("map = " + map);

        System.out.println("--------------------------------------------------------------------------");
//        实现Map中元素的查找
        boolean b = map.containsKey("1");
        System.out.println("b = " + b);

        b = map.containsValue("two");
        System.out.println("b = " + b);

        b = map.containsValue("t w o");
        System.out.println("b = " + b);

        String s = map.get("1");
        System.out.println("s = " + s);

        s = map.get("5");
        System.out.println("s = " + s);

        System.out.println("--------------------------------------------------------------------------");
//        实现删除操作
        String r1 = map.remove("1");
        System.out.println("r1 = " + r1);
        System.out.println("map = " + map);

        System.out.println("--------------------------------------------------------------------------");

//        实现Map的三种遍历
//        获取所有Key组成的Set视图
        Set<String> keys = map.keySet();
        for (String str : keys) {
            System.out.println("str = " + str + " = " + map.get(str));
        }

//        获取所有Value组成Collection视图
        Collection<String> collection = map.values();
        for (String val : collection) {
            System.out.println("val = " + val);
        }

//        获取Map中所有的键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("entry = " + entry);
        }

    }
}
