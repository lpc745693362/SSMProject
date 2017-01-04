package com.lpc.other.advice;

/**
 * Created by liupengcheng1 on 2016/12/27.
 */
public interface Waiter {

    /**
     * 欢迎
     * @param name
     */
    void greetTo(String name);

    /**
     * 服务
     * @param name
     */
    void serveTo(String name);

}
