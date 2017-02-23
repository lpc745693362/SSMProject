package com.lpc.other.net;

import java.net.InetAddress;

/**
 * Created by liupengcheng1 on 2017/2/23.
 */
public class InetAdressTest {

    public static void main(String[] args) throws Exception{

        // 使用域名创建对象
        InetAddress inet1 = InetAddress.getByName("www.jd.com");
        System.out.println("inet1：" + inet1);

        // 使用ip创建对象
        InetAddress inet2 = InetAddress.getByName("127.0.0.1");
        System.out.println("inet2：" + inet2);

        // 获取本地主机对象
        InetAddress inet3 = InetAddress.getLocalHost();
        System.out.println("inet3：" + inet3);
        System.out.println("inet3-IP：" + inet3.getHostAddress()); // 获取本地主机Ip
        System.out.println("inet3-域名：" + inet3.getHostName()); // 获取本地主机名

    }

}
