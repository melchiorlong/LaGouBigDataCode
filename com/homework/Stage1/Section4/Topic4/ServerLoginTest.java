package com.homework.Stage1.Section4.Topic4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tianlong
 */
public class ServerLoginTest {

    /**
     * 创建ServerSocket类型的对象并提供端口号
     * 等待客户端的连接请求，调用accept方法
     * 使用输入输出流进行通信
     * 关闭Socket并释放相关资源
     */

    private static final String TRUE_NAME = "admin";
    private static final String TRUE_PASS = "123456";


    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            ss = new ServerSocket(8888);
            System.out.println("等待客户端连接.....");
            s = ss.accept();
            System.out.println("客户端连接成功！！！");
            ois = new ObjectInputStream(s.getInputStream());
            UserMessage umIn1 = (UserMessage) ois.readObject();
            String userName = umIn1.getUser().getUserName();
            String passWord = umIn1.getUser().getPassWord();
            if (TRUE_NAME.equals(userName) && TRUE_PASS.equals(passWord)){
                umIn1.setType("success");
            } else {
                umIn1.setType("fail");
            }

            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(umIn1);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
