package com.lpc.other.io;

import java.io.FileInputStream;
import java.util.Arrays;

/**
 * 读取本地文件中的字节数据
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        FileInputStreamTest streamTest = new FileInputStreamTest();
        streamTest.readOne();
        streamTest.readTwo();

    }

    /**
     * 一次读取一个字节
     */
    public void readOne() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\export\\lpc\\test\\io.txt");
            for (int i = 0; i < 10; i++) {
                System.out.println("一次读取一个字节：" + fileInputStream.read());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按字节数组长度读取数据
     */
    public void readTwo() {
        FileInputStream fileInputStream = null;
        byte b[] = new byte[2];
        try {
            fileInputStream = new FileInputStream("D:\\export\\lpc\\test\\io.txt");
            for (int i = 0; i < 10; i++) {
                System.out.println("按字节数组长度读取：" + fileInputStream.read(b) + "；读取后数组b的内容为：" + Arrays.toString(b));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
