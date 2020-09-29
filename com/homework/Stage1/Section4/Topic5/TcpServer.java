package com.homework.Stage1.Section4.Topic5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianlong
 * 使用基于 tcp 协议的编程模型实现多人同时在线聊天和传输文件，
 * 要求每个客户端将发送的聊天内容和文件发送到服务器
 * 服务器接收到后转发给当前所有在线的客户端。
 */

public class TcpServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        List<Socket> socketList = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(8888);
            while (true){
                System.out.println("等待客户端连接....");
                System.out.println("socketList = " + socketList);
                socket = serverSocket.accept();
                socketList.add(socket);
                System.out.println("地址为：" + socket.getInetAddress() + "的客户端连接成功！");

                new TcpServerThread(socket, socketList).start();
                System.out.println("socketList = " + socketList);

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
