package com.lpc.other.aop;


/**
 * Created by liupengcheng1 on 2016/12/22.
 */
public class ForumServiceImpl implements ForumService {

    @Override
    public void removeTopic(int topicId) {
        // 开始对方法性能进行监测
        PerformancesMonitor.begin("com.lpc.other.aop.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录：" + topicId);
        try {
            Thread.currentThread().sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 结束对方法性能的监测
        PerformancesMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        // 开始对方法性能进行监测
        PerformancesMonitor.begin("com.lpc.other.aop.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录：" + forumId);
        try {
            Thread.currentThread().sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 结束对方法性能的监测
        PerformancesMonitor.end();
    }
}
