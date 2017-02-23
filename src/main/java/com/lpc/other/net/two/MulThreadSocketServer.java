package com.lpc.other.net.two;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 支持多客户端的服务端实现
 * <P>接收客户端连接后创建线程处理该连接</P>
 */
public class MulThreadSocketServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket;
        int port = 10001; // 监听端口

        try {
            // 监听端口
            serverSocket = new ServerSocket(port);
            System.out.println("=============端口已监听=============");

            while (true) {
                // 接收连接
                socket = serverSocket.accept();
                // 创建新线程处理该连接
                DealThread dealThread = new DealThread(socket);
                Thread thread = new Thread(dealThread);
                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
