package com.study.Stage1.Section4.Task1.ObjectIOStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author tianlonf
 */
public class ObjectOutputStreamTest {

    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            // 1、创建ObjectOutputStream类型的对象与d:/a.txt 文件关联
            oos = new ObjectOutputStream(new FileOutputStream("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage1\\Section4\\Task1\\ObjectIOStream\\a.txt"));
            // 2、准备一个User类型的对象并初始化
            User user = new User("admin", "123456", "13461111111");
            // 3、将整个User类型的对象写入输出流
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭流对象并释放相关资源
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
