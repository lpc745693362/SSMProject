package com.lpc.other.aop.cglibProxy;

import com.lpc.other.aop.jdkProxy.ForumServiceImpl2;

/**
 * Created by liupengcheng1 on 2016/12/22.
 */
public class Test {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        ForumServiceImpl2 forumServiceImpl2 = (ForumServiceImpl2) cglibProxy.getProxy(ForumServiceImpl2.class);
        forumServiceImpl2.removeTopic(10);
        forumServiceImpl2.removeForum(20);
    }

}
