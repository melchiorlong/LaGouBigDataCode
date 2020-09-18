package com.study.Stage1.Section4.Task4.UDPModual;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class SendTest {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            // 1、创建DatagramSocket类型的对象
            datagramSocket = new DatagramSocket();
            // 2、创建DatagramPacket类型的对象，并提供接收方通信地址及端口号
            byte[] b = "hello".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 8888);
            // 3、通过Socket发送Packet，调用send方法
            datagramSocket.send(datagramPacket);

            // 接收回传的消息
            byte[] backArr = new byte[20];
            DatagramPacket dp2 = new DatagramPacket(backArr,backArr.length);
            datagramSocket.receive(dp2);
            System.out.println("接收到的回发数据是" + new String(backArr,0,dp2.getLength()) + "!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭Socket并释放相关资源
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
