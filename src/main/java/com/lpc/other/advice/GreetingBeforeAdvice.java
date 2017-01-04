package com.lpc.other.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object object) throws Throwable {
        String name = (String) args[0];
        System.out.println("How are you! Mr." + name);
    }
}
