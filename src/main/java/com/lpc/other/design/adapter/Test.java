package com.lpc.other.design.adapter;

/**
 * 适配器模式：用户角色
 */
public class Test {

    public static void main(String[] args) {

        // 类的适配器模式测试
        Target target = new ClassAdapter();
        target.target();

        // 对象的适配器模式测试
        Adaptee adaptee = new Adaptee();
        Target t = new ObjectAdapter(adaptee);
        t.target();

    }

}
