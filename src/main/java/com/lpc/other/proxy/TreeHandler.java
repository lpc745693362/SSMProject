package com.lpc.other.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 */
public class TreeHandler implements InvocationHandler {

    private Object target;

    public TreeHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // before invoke
        System.out.println("I am 格鲁特!");
        Object object = method.invoke(target, args);
        // after invoke
        System.out.println("I am a Tree Man!");
        return object;
    }
}
