package com.lpc.other.design.adapter;

/**
 * （类的）适配器模式：适配器角色
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void target() {
        this.run();
    }
}
