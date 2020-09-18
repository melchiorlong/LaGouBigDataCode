package com.study.Stage1.Section4.Task4.CSModual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {


    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;
        boolean flag = true;

        try {
            while (flag) {
                InetAddress inetAddress = socket.getInetAddress();
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(socket.getOutputStream());

                String s = br.readLine();
                System.out.println("客户端" + inetAddress + "发来的数据是：" + s);
                // 实现服务器向客户端回发字符串内容
                ps.println("Received");
                if ("bye".equalsIgnoreCase(s)) {
                    System.out.println("聊天结束客户端" + inetAddress + "已关闭！");
                    flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (br != null) {
                try {
                    br.close();
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
