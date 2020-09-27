package com.study.Stage1.Section4.Task1.ObjectIOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author tianlong
 */
public class ObjectInputStreamTest {

    public static void main(String[] args) {
        ObjectInputStream ois = null;

        try {
            // 1、创建ObjectInputStream类型的对象与文件关联
            ois = new ObjectInputStream(new FileInputStream("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage1\\Section4\\Task1\\ObjectIOStream\\a.txt"));
            // 2、从输入流中读取一个对象并打印
            Object o = ois.readObject();
            System.out.println("o = " + o);
            // 3、关闭流对象并释放资源
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
