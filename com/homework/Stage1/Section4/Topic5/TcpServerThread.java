package com.homework.Stage1.Section4.Topic5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianlong
 * 使用基于 tcp 协议的编程模型实现多人同时在线聊天和传输文件，
 * 要求每个客户端将发送的聊天内容和文件发送到服务器
 * 服务器接收到后转发给当前所有在线的客户端。
 */
public class TcpServerThread extends Thread {

    private final List<Socket> socketList;
    private final Socket socket;

    public TcpServerThread(Socket socket, List<Socket> socketList) {
        this.socket = socket;
        this.socketList = socketList;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;
        boolean flag = true;
        try {
            while (flag) {
                SocketAddress socketAddress = socket.getRemoteSocketAddress();
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String readLine = br.readLine();
                System.out.println("客户端" + socketAddress + "发来的数据是：" + readLine);
                if ("bye".equals(readLine)) {
                    sendClose();
                    System.out.println("聊天结束客户端" + socketAddress + "已关闭！");
                    socketList.remove(socket);
                    flag = false;
                }
                for (Socket so : socketList) {
                    if (socket != so){
                        ps = new PrintStream(so.getOutputStream());
                        ps.println(readLine);
                    }
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
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void sendClose(){
        TcpClientSendThread tcpClientSendThread = new TcpClientSendThread(socket);
        tcpClientSendThread.sendString("bye");

    }
}

