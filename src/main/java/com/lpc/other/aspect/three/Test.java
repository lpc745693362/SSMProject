package com.lpc.other.aspect.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liupengcheng1 on 2017/2/16.
 */
public class Test {

    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
            Monkey monkey = (Monkey) applicationContext.getBean("monkey");
            monkey.stealPeaches("孙大圣的徒弟");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
