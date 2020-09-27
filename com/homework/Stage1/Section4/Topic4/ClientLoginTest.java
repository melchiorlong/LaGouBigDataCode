package com.homework.Stage1.Section4.Topic4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author tianlong
 */
public class ClientLoginTest {

    /**
     * 创建Socket类型的对象并提供服务器的主机名和端口号
     * 使用输入输出流进行通信
     * 关闭Socket并释有关的资源
     */

    public static void main(String[] args) {
        Socket socket = null;
        UserMessage umOut1 = new UserMessage("check", new User("admin", "123456"));
//        UserMessage umOut1 = new UserMessage("check", new User("test", "test"));
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        boolean isLoginSuccess;

        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功!!!!");
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(umOut1);

            ois = new ObjectInputStream(socket.getInputStream());
            UserMessage umIn = (UserMessage) ois.readObject();
            isLoginSuccess = "success".equals(umIn.getType());
            System.out.println(isLoginSuccess ? "登录成功！！！" : "登陆失败，请重试！");

            System.out.println("UserMessage中Type的值为 " + umIn.getType());


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
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
