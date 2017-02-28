package com.lpc.other.design.facade;

/**
 * 外观模式：子系统角色 实现类
 */
public class SubServiceAImpl implements SubServiceA {
    @Override
    public void methodA() {
        System.out.println("This is A Method !");
    }
}
