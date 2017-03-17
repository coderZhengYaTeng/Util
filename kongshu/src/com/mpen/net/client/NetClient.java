package com.mpen.net.client;

import java.net.*;
import java.io.*;

public class NetClient {

    public static void main(String[] args) {
        Socket client = null;
        ClientJieShouThread crt = null;
        BufferedReader br = null;
        try {
            client = new Socket("192.168.44.176", 5000);
            crt = new ClientJieShouThread(client);
            br = new BufferedReader(new InputStreamReader(System.in));
            OutputStream out = client.getOutputStream();
            PrintStream ps = new PrintStream(out);
            while (true) {
                String str = br.readLine();
                if (str == null) {
                }
                // 处理空格
                if (str.trim().length() == 0) {
                    continue;
                }
                ps.println(str);
                // 处理退出
                if ("exit".equalsIgnoreCase(str)) {
                    crt.setStop(true);
                    break;
                }
            }
            System.out.println("【客户端提示信息】客户端主线程将退出");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            if (e.getMessage().equals("Connection refused: connect")) {
                System.err.println("【客户端提示信息】服务器尚未启动,请确认.");
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                crt.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
