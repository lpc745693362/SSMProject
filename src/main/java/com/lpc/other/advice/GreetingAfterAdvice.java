package com.lpc.other.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置增强
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    /**
     * @param returnObj 目标实例方法返回的结果
     * @param method    目标类的方法
     * @param args      方法的入参
     * @param object    目标类
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnObj, Method method, Object[] args, Object object) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }

}
