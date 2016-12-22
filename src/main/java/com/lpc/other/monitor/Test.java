package com.lpc.other.monitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MailSender mailSender = (MailSender) context.getBean("mailSender");
        mailSender.sendMail("liupengcheng@jd.com");
    }

}
