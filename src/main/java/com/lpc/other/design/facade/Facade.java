package com.lpc.other.design.facade;

/**
 * 外观模式：门面类（核心）
 */
public class Facade {

    private SubServiceA subServiceA;
    private SubServiceB subServiceB;

    public Facade(){
        subServiceA = new SubServiceAImpl();
        subServiceB = new SubServiceBImpl();
    }

    public void test1(){
        subServiceA.methodA();
    }

    public void test2(){
        subServiceA.methodA();
        subServiceB.methodB();
    }

}
