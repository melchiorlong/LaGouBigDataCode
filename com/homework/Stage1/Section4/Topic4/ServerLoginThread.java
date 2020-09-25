package com.homework.Stage1.Section4.Topic4;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author tianlong
 */
public class ServerLoginThread extends Thread {


    private final Socket socket;

    public ServerLoginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        while (true) {
            try {
                InetAddress inetAddress = socket.getInetAddress();
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
                Object inObj = ois.readObject();

                oos.writeObject(inObj);



            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
