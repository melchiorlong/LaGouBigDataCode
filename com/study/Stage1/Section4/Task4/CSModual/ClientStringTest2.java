package com.study.Stage1.Section4.Task4.CSModual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringTest2 {

    public static void main(String[] args) {

        /**
         * 创建Socket类型的对象并提供服务器的主机名和端口号
         * 使用输入输出流进行通信
         * 关闭Socket并释有关的资源
         */

        Socket socket = null;
        PrintStream ps = null;
        BufferedReader br = null;
        Scanner sc = null;
        boolean flag = true;
        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功。");
            sc = new Scanner(System.in);
            ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (flag) {
                System.out.println("请输入要发送的数据内容：");
                String input = sc.next();

                    ps.println(input);
                    System.out.println("客户端发送数据成功");

                    String s = br.readLine();
                    System.out.println("客户端接收数据成功。");
                    System.out.println("返回内容是：" + s);
                if ("bye".equals(input)) {
                    System.out.println("聊天结束。");
                    flag = false;
                }
            }


        } catch (IOException /*| InterruptedException*/ e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
            if (ps != null) {
                ps.close();
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
