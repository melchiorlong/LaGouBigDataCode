package com.study.Stage1.Section4.Task4.UDPModual;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveTest {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            // 1、创建DatagramSocket类型的对象，并提供端口号
            datagramSocket = new DatagramSocket(8888);
            // 2、创建Datagrampacket类型的对象，并提供缓冲区
            byte[] b = new byte[20];
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length);
            // 3、通过Socket接收数据内容，存放到packet中，调用receive方法
            System.out.println("等到数据的到来");
            datagramSocket.receive(datagramPacket);
            System.out.println("接收到的数据是：" + new String(b, 0, datagramPacket.getLength()) + "!");

            // 实现将"I received！" 回发
            byte[] backArr = "I received！".getBytes();
            DatagramPacket dp2 = new DatagramPacket(backArr, backArr.length, datagramPacket.getAddress(),datagramPacket.getPort());
            datagramSocket.send(dp2);
            System.out.println("回发数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、 关闭Socket并释放相关资源
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
