package com.lpc.other.net.one;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单Socket服务端（C/S模式）
 * <p>功能为：接收客户端发送的消息，并返回“World”</p>
 */
public class SimpleSocketServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int port = 10000; // 监听端口
        String data = "World"; // 返回给客户端的数据

        try {
            // 监听端口
            serverSocket = new ServerSocket(port);
            System.out.println("==========端口已监听=========");

            // 建立连接
            socket = serverSocket.accept();
            System.out.println("==========连接已建立=========");

            // 接收客户端发送数据
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println("客户端发送的内容：" + new String(bytes, 0, len));

            // 向客户端发送反馈内容
            outputStream = socket.getOutputStream();
            outputStream.write(data.getBytes());
            System.out.println("==========已返回数据World=========");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
