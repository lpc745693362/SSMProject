package com.lpc.other.aop;


/**
 * Created by liupengcheng1 on 2016/12/22.
 */
public class Test {

    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(10);
        forumService.removeForum(20);
    }

}
