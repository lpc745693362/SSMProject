package com.lpc.other.net.two;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 简单的Socket客户端
 */
public class SocketClientTwo {

    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String serverIp = "127.0.0.1"; // 服务器端IP
        int port = 10001; // 端口
        String data = "Hello Two"; // 发送内容

        try {
            // 建立连接
            socket = new Socket(serverIp, port);
            System.out.println("与服务端连接已建立：" + System.currentTimeMillis());

            // 发送数据
            outputStream = socket.getOutputStream();
            outputStream.write(data.getBytes());
            System.out.println("已向服务端发送数据：" + System.currentTimeMillis());

            // 接收数据
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println("服务器反馈内容：" + new String(bytes, 0, len));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
