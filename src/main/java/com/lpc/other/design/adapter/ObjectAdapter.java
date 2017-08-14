package com.lpc.other.design.adapter;

/**
 * （对象的）适配器模式：适配器角色
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void target() {
        adaptee.run();
    }

}
