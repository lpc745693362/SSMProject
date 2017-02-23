package com.lpc.other.net.two;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 服务端逻辑处理线程
 */
public class DealThread implements Runnable {

    private Socket socket;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private String data = "Copy That"; // 返回给客户端的数据


    public DealThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 初始化流
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            // 接收数据
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println("接收客户端数据：" + new String(bytes, 0, len));

            // 反馈数据
            outputStream = socket.getOutputStream();
            outputStream.write(data.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 关闭流和连接
     */
    private void close() {
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
