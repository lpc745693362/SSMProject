package com.lpc.other.design.chain;

/**
 * 责任链模式：具体处理者角色 总经理
 */
public class GeneralManager extends Handler {
    @Override
    public boolean handleFee(String userName, double fee) {
        // 总经理审批1000（含）以内的申请
        if (fee <= 10000) {
            // 只同意root同学的申请
            if ("root".equals(userName)) {
                System.out.println("成功：总经理同意【" + userName + "】的聚餐费用，金额为 " + fee + " 元！");
            } else {
                System.out.println("失败：总经理不同意【" + userName + "】的聚餐费用，金额为 " + fee + " 元！");
            }
        } else {
            // 超过10000继续传递给更高级别的人处理
            if (getHandler() != null) {
                System.out.println("总经理无此审批权限，转交毛爷爷审批吧！");
                return getHandler().handleFee(userName, fee);
            }
        }

        return true;
    }
}
