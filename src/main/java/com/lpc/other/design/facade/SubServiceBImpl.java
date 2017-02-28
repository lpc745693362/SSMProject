package com.lpc.other.design.facade;

/**
 * 外观模式：子系统角色 实现类
 */
public class SubServiceBImpl implements SubServiceB {
    @Override
    public void methodB() {
        System.out.println("This is B Method !");
    }
}
