package com.lpc.other.design.chain;

/**
 * 责任链模式：具体处理者角色 部门经理
 */
public class DeptManager extends Handler {
    @Override
    public boolean handleFee(String userName, double fee) {
        // 部门经理审批5000（含）以内的申请
        if (fee <= 5000) {
            // 只同意root同学的申请
            if ("root".equals(userName)) {
                System.out.println("成功：部门经理同意【" + userName + "】的聚餐费用，金额为 " + fee + " 元！");
            } else {
                System.out.println("失败：部门经理不同意【" + userName + "】的聚餐费用，金额为 " + fee + " 元！");
            }
        } else {
            // 超过5000继续传递给更高级别的人处理
            if (getHandler() != null) {
                System.out.println("部门经理无此审批权限，转交总经理审批！");
                return getHandler().handleFee(userName, fee);
            }
        }

        return true;
    }
}
