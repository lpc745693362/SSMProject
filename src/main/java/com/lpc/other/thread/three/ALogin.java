package com.lpc.other.thread.three;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class ALogin extends Thread {

    public void run(){
        LoginServlet.doPost("a", "aa");
    }

}
