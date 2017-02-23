package com.lpc.other.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 输入输出流测试
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws Exception {
        FileOutputStreamTest outputStreamTest = new FileOutputStreamTest();
        outputStreamTest.copy();
    }

    /**
     * 将输入流数据复制到输出流，完成copy
     *
     * @throws Exception
     */
    public void copy() throws Exception {

        FileInputStream inputStream = new FileInputStream("D:\\Lpc\\002.jpg"); // 输入流数据源
        FileOutputStream outputStream = new FileOutputStream("D:\\Lpc\\girl.jpg"); // 输出目的地

        byte[] b = new byte[1024];
        int len = 0;
        int count = 0;

        while ((len = inputStream.read(b)) != -1) {
            count++;
            outputStream.write(b, 0, len);
        }

        inputStream.close();
        outputStream.close();

        System.out.println(count);

    }


}
