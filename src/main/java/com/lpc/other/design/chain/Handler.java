package com.lpc.other.design.chain;

/**
 * 责任链模式：抽象处理者角色
 */
public abstract class Handler {

    protected Handler handler;


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * 处理聚餐费用的申请
     * @param userName 申请人
     * @param fee 费用
     * @return
     */
    public abstract boolean handleFee(String userName, double fee);

}
