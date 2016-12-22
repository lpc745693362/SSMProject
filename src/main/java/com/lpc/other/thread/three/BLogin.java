package com.lpc.other.thread.three;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class BLogin implements Runnable {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
