package com.study.Stage1.Section4.Task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamTest {

    public static void main(String[] args) {

//        1、创建输出流与文件关联
        User user = new User("tianlong", "123456", "13466300226");
        ObjectOutputStream oop = null;
        try {
            oop = new ObjectOutputStream(new FileOutputStream("/Users/tianlong/Desktop/a.txt"));
            oop.writeObject(user);
            System.out.println("写入成功。");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oop != null) {
                    oop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
