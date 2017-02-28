package com.lpc.other.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理测试类
 */
public class Test {

    public static void main(String[] args) {
        Tree target = new PineTree(); // 被代理类
        TreeHandler treeHandler = new TreeHandler(target);
        // 生成代理类
        Tree proxy = (Tree) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), treeHandler);
        proxy.grew();
        System.out.println("=======================================");

        System.out.println("proxy是否是Proxy的一个实例：" + (proxy instanceof Proxy));
        System.out.println("proxy的Class类是：" + proxy.getClass().toString());
        System.out.println("proxy的父类是：" + proxy.getClass().getSuperclass());
        System.out.println("proxy实现的接口是：");
        Class<?> interfaces[] = proxy.getClass().getInterfaces();
        for (Class<?> clazz : interfaces) {
            System.out.println(clazz.getName());
        }

    }

}
