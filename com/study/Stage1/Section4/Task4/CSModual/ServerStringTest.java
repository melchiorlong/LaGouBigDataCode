package com.study.Stage1.Section4.Task4.CSModual;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建ServerSocket类型的对象并提供端口号
 * 等待客户端的连接请求，调用accept方法
 * 使用输入输出流进行通信
 * 关闭Socket并释放相关资源
 */

public class ServerStringTest {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                System.out.println("等待客户端的连接请求...");
                socket = serverSocket.accept();
                System.out.println("客户端" + socket.getInetAddress() + "连接成功");

                // 每当一个客户端连接成功，则需要开启一个新的线程
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
