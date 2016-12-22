package com.lpc.other.aop.cglibProxy;

import com.lpc.other.aop.PerformancesMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liupengcheng1 on 2016/12/22.
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 通过字节码动态技术创建子类实例
        return enhancer.create();
    }

    /**
     * 拦截父类所有方法的调用
     * @param object
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformancesMonitor.begin(object.getClass().getName() + "." + method.getName());
        // 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(object, args);
        PerformancesMonitor.end();
        return result;
    }

}
