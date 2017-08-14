package com.lpc.other.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 */
public class GreetingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object args[] = invocation.getArguments();
        String name = (String) args[0];
        System.out.println("surround before ... " + name);
        // 通过反射机制调用目标方法
        Object object = invocation.proceed();
        System.out.println("surround after ... " + name);
        return object;
    }

}
