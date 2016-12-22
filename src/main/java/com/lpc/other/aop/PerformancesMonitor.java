package com.lpc.other.aop;


/**
 * 性能监测
 */
public class PerformancesMonitor {

    private static ThreadLocal<MethodPreformances> threadLocal = new ThreadLocal<MethodPreformances>();

    /**
     * 方法性能监测开始
     *
     * @param name
     */
    public static void begin(String name) {
        System.out.println("monitor begin ... ");
        MethodPreformances methodPreformances = new MethodPreformances(name);
        threadLocal.set(methodPreformances);
    }

    /**
     * 方法性能监测结束
     */
    public static void end() {
        System.out.println("monitor end ...");
        MethodPreformances methodPreformances = threadLocal.get();
        methodPreformances.printPreformances();
    }

}
