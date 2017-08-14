package com.lpc.other.advice;

/**
 * Created by liupengcheng1 on 2016/12/27.
 */
public class NaiveWaiter implements Waiter {

    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    public void serveTo(String name) {
        System.out.println("serving " + name);
    }

}

