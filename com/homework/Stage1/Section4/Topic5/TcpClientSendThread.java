package com.homework.Stage1.Section4.Topic5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author tianlong
 */
public class TcpClientSendThread extends Thread {

    private final Socket socket;

    public TcpClientSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
//        PrintStream ps = null;
        Scanner sc = null;
        boolean flag = true;

        sc = new Scanner(System.in);
        while (flag) {
            System.out.println("请选择要传输的内容：1、文字， 2、文件");
            String choose = sc.next();
            if ("1".equals(choose)) {
                System.out.println("请输入要发送的数据内容：");
                String input = sc.next();
                sendString(input);
                System.out.println("客户端发送数据成功");
            } else if ("2".equals(choose)) {
                System.out.println("请输入要发送的文件路径：");
                String path = sc.next();
                sendObject(path);
                System.out.println("客户端发送数据成功");
            } else if ("bye".equals(choose)) {
                System.out.println("聊天结束。");
                sendString("bye");
                flag = false;
            } else {
                System.out.println("输入错误，请重新输入。");
            }
        }

    }

    public void sendString(String input) {
        PrintStream ps;
        try {
            ps = new PrintStream(socket.getOutputStream());
            ps.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(String path) {
        File file;
        FileInputStream fis = null;
        ObjectOutputStream oos = null;

        try {
            file = new File(path);
            fis = new FileInputStream(file);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
