package com.homework.Stage1.Section4.Topic5;

import java.io.IOException;
import java.net.Socket;

/**
 * @author tianlong
 * 创建Socket类型的对象并提供服务器的主机名和端口号
 * 使用输入输出流进行通信
 * 关闭Socket并释有关的资源
 */
public class TcpClient3 {

    public static void main(String[] args) {

        Socket socket;

        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");

            new TcpClientReceiveThread(socket).start();
            new TcpClientSendThread(socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
