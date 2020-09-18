package com.study.Stage1.Section4.Task5;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class PersonConstractorTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {

        // 1、使用原始方式以无参形式构造Person类型的对象并打印
        Person p1 = new Person();
//        System.out.println("无参方式创建的对象p1是 " + p1);

        System.out.println("===============================================");

        // 2、以反射机制构造Person类型的对象并打印
//        System.out.println("请输入要创建对象的类型：");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
        // Class c1 = Class.forName("com.study.Stage1.Section4.Task5.Person");
//        Class c1 = Class.forName(str);

        FileInputStream fis = new FileInputStream("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage1\\Section4\\Task5\\a.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        Class c1 = Class.forName(br.readLine());

        System.out.println("无参方式创建的对象p1是 " + c1.newInstance());
//        sc.close();

        System.out.println("===============================================");

        // 获取Class对象中对应的无参构造方法
        Constructor constructor = c1.getConstructor();
        // 使用获取到的无参构造方法来构造对应类型的对象，也就是Person类型的对象
        System.out.println("无参方式创建的对象p1是 " + constructor.newInstance());

        System.out.println("===============================================");

        // 使用原始方式以有参方式构造Person类型的对象并打印
        Person p2 = new Person("zhangfei", 30);
        System.out.println("有参方式构造的对象是： " + p2);

        System.out.println("===============================================");

        // 使用反射机制以有参方式构造Person类型的对象并打印
        // 获取Class对象对应类中的有参构造方法，也就是Person类中的有参构造方法
        Constructor constructor2 = c1.getConstructor(String.class, int.class);
        // 使用获取到的有参构造方法来构造对应类型的对象，也就是Person类型的对象
        // newInstance中的实参是给构造方法中的形参初始化的
        System.out.println("有参方式构造的对象是： " + constructor2.newInstance("zhangfei", 30));

        System.out.println("===============================================");

        // 5、使用反射机制获取Person类中的所有构造方法并打印
        Constructor[] constructors = c1.getConstructors();
        for (Constructor ct : constructors) {
            System.out.println("构造方法的访问修饰符是 " + ct.getModifiers());
            System.out.println("构造方法的方法名称是 " + ct.getName());
            Class[] parameterTypes = ct.getParameterTypes();
            System.out.print("构造方法的所有参数类型是 ");
            for (Class cs : parameterTypes) {
                System.out.print(cs + "    ");
            }
            System.out.println();
            System.out.println("----------------------------");
        }

    }
}
