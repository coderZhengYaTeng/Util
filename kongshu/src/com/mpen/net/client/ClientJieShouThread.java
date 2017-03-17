package com.mpen.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

// 客户端接收数据的线程

public class ClientJieShouThread extends Thread {

    private Socket socket;

    private boolean isStop = false;

    public void setStop(boolean isStop) {
        this.isStop = isStop;
    }

    public ClientJieShouThread(Socket socket) {
        this.socket = socket;
        start();
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            while (!isStop) {
                String str = br.readLine();
                if (str == null) {
                    break;
                }
                System.out.println(str);
            }
            System.out.println("【客户端提示信息】接收线程将停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
