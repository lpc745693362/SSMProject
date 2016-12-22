package com.lpc.other.aop.jdkProxy;

import com.lpc.other.aop.PerformancesMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liupengcheng1 on 2016/12/22.
 */
public class PerformanceHandler implements InvocationHandler {

    // 目标的业务类
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformancesMonitor.begin(target.getClass().getName() + "." + method.getName());
        // 通过反射方法调用业务类的目标方法
        Object object = method.invoke(target, args);
        PerformancesMonitor.end();
        return object;
    }

}
