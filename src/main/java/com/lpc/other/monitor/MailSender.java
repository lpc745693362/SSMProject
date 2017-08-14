package com.lpc.other.monitor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class MailSender implements ApplicationContextAware {

    private ApplicationContext context;

    /**
     * ApplicationContextAware的接口方法，以便容器启动时注入容器实例
     *
     * @param context
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public void sendMail(String to) {
        System.out.println("MailSender：模拟发送邮件。。。");
        MailSendEvent event = new MailSendEvent(context, to);
        context.publishEvent(event);
    }

}
