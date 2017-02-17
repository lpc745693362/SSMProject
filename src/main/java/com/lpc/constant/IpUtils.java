package com.lpc.constant;

import com.lpc.constant.Constants;

import java.net.InetAddress;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public class IpUtils {

    public static String getIp() {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (Exception e) {
            ip = Constants.LOCAL_IP;
        }
        return ip;
    }

}
