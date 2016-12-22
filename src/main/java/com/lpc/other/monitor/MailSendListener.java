package com.lpc.other.monitor;

import org.springframework.context.ApplicationListener;

/**
 * 监听类
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {

    /**
     * 对MailSendEvent事件进行处理
     * @param mailSendEvent
     */
    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("MailSendListener：向" + mailSendEvent.getTo() + "发送了一封邮件！");
    }

}
