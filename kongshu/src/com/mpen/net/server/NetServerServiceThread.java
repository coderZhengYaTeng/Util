package com.mpen.net.server;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;

import com.mpen.util.MouseUtil;

public class NetServerServiceThread extends Thread {

    private Socket socket;
    private String clientAddr;

    private Map<String, Socket> map;

    public NetServerServiceThread(Socket socket, Map<String, Socket> map) {
        this.socket = socket;
        this.clientAddr = socket.getInetAddress().getHostAddress();
        this.map = map;
        start();
    }

    /**
     * 向指定的Socket发送String格式的数据
     * 
     * @param msg
     * @param socket
     */
    public void sendMsgToSocket(String msg, Socket socket) {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        int x = (int) mousePoint.getX();
        int y = (int) mousePoint.getY();
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String str = br.readLine();
                if (str == null) {
                    System.err.println("【服务器提示信息】客户端" + clientAddr + "非法关闭,服务器通讯线程也要关闭.");
                    map.remove("clientAddr");
                    break;
                }
                // 处理退出
                if ("exit".equalsIgnoreCase(str)) {
                    System.out.println("【服务器提示信息】客户端" + clientAddr + "要退出,服务器通讯线程也要关闭");
                    map.remove("clientAddr");
                    break;
                }
                if ("1".equals(str)) {
                    x = x + 10;
                    y = y + 10;
                    MouseUtil.move(x, y);
                } else if ("2".equals(str)) {
                    MouseUtil.leftCLick();
                } else if ("3".equals(str)) {
                    MouseUtil.rightCLick();
                }
            }
        } catch (IOException e) {
            if (e.getMessage().equals("Connection reset")) {
                System.err.println("【服务器提示信息】客户端" + clientAddr + "非法关闭,服务器通讯线程也要关闭.");
                map.remove("clientAddr");
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
