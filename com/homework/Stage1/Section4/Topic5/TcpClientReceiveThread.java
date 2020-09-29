package com.homework.Stage1.Section4.Topic5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/**
 * @author tianlong
 */
public class TcpClientReceiveThread extends Thread {

    private final Socket socket;


    public TcpClientReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String readLine = br.readLine();
                if ("bye".equals(readLine)){
                    sendClose();
                    break;
                } else {
                    System.out.println("客户端接收数据成功。");
                    System.out.println("来自客户端" + socket.getRemoteSocketAddress() + "接收到的返回内容是：" + readLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendClose(){
        TcpClientSendThread tcpClientSendThread = new TcpClientSendThread(socket);
        tcpClientSendThread.sendString("bye");

    }



}
