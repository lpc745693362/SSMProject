package com.lpc.other.aop;

/**
 * 方法性能
 */
public class MethodPreformances {
    private long beginTime; // 方法开始时间
    private long endTime; // 方法结束时间
    private String methodName; // 方法名称

    public MethodPreformances(String name) {
        this.methodName = name;
        beginTime = System.currentTimeMillis();
    }

    /**
     * 打印方法性能监测的结果
     */
    public void printPreformances() {
        endTime = System.currentTimeMillis();
        long elapse = endTime - beginTime;
        System.out.println(methodName + "耗时" + elapse + "毫秒！");
    }

}
