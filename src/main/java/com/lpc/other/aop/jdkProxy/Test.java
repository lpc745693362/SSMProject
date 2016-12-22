package com.lpc.other.aop.jdkProxy;

import com.lpc.other.aop.ForumService;

import java.lang.reflect.Proxy;

/**
 * Created by liupengcheng1 on 2016/12/22.
 */
public class Test {

    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl2();
        PerformanceHandler performanceHandler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), performanceHandler);
        proxy.removeTopic(10);
        proxy.removeForum(20);
    }

}
