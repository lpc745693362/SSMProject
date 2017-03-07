package com.lpc.other.design.chain;

/**
 * 责任链模式：客户端角色 测试类
 */
public class Test {

    public static void main(String[] args) {
        // 组装责任链
        Handler handler1 = new ProjectManager();
        Handler handler2 = new DeptManager();
        Handler handler3 = new GeneralManager();
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);

        handler1.handleFee("root", 8888);

    }

}
