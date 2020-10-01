package com.homework.Stage1.Section4.Topic5;

import java.io.*;
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
        ObjectInputStream ois = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
//                String readLine = br.readLine();
                String readLine = "";
                Object obj = ois.readObject();
                if(obj instanceof String){
                    readLine = br.readLine();
                } else if (obj instanceof ObjectOutputStream){
                    FileOutputStream fos;
                    fos = new FileOutputStream("/Users/tianlong/Desktop/LaGouBigDataStudy/src/com/homework/Stage1/Section4/Topic5/Client_2_File");



                }


                if ("bye".equals(readLine)){
                    sendClose();
                    break;
                } else {
                    System.out.println("客户端接收数据成功。");
                    System.out.println("来自客户端" + socket.getRemoteSocketAddress() + "接收到的返回内容是：" + readLine);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
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
