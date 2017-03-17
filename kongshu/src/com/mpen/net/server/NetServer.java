package com.mpen.net.server;

import java.net.*;
import java.util.*;
import java.io.*;

public class NetServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        String clientAddr = null;

        Map<String, Socket> map = new Hashtable<String, Socket>();
        try {
            server = new ServerSocket(5000);

            System.out.println("【服务器提示信息】服务器已经启动,等待客户端的连接.......");

            while (true) {
                Socket socket = server.accept();
                InetAddress ia = socket.getInetAddress();
                clientAddr = ia.getHostAddress();
                System.out.println("【服务器提示信息】服务器受到客户端" + clientAddr + "的连接请求");
                // 当总机接收到客户端的连接并且返回和客户端连接的分机Socket之后,总机把客户端的信息保存到集合中
                map.put(clientAddr, socket);
                NetServerServiceThread sst = new NetServerServiceThread(socket, map);
            }
        } catch (IOException e) {
            if (e.getMessage().equals("Unrecognized Windows Sockets error: 0: JVM_Bind")) {
                System.err.println("【服务器提示信息】目标端口已经被占用,请确认!");
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
