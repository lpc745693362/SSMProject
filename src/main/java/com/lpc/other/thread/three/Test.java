package com.lpc.other.thread.three;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class Test {

    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();

        BLogin bLogin = new BLogin();
        Thread thread = new Thread(bLogin);
        thread.start();
    }

}
