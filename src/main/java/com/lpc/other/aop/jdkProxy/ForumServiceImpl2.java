package com.lpc.other.aop.jdkProxy;

import com.lpc.other.aop.ForumService;

/**
 * 使用JDK动态代理模拟方法性能监测
 */
public class ForumServiceImpl2 implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录：" + topicId);
        try {
            Thread.currentThread().sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录：" + forumId);
        try {
            Thread.currentThread().sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
