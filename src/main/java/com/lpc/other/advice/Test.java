package com.lpc.other.advice;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by liupengcheng1 on 2016/12/27.
 */
public class Test {

    public static void main(String[] args) {
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        AfterAdvice afterAdvice = new GreetingAfterAdvice();

        // Spring 提供的代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置代理目标
        proxyFactory.setTarget(waiter);
        // 为代理目标添加增强
        proxyFactory.addAdvice(beforeAdvice);
        proxyFactory.addAdvice(afterAdvice);
        // 生成代理实例
        Waiter proxyWaiter = (Waiter) proxyFactory.getProxy();

        proxyWaiter.greetTo("John");
        proxyWaiter.serveTo("Tom");
    }

}
