package com.lpc.other.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.StringUtils;

/**
 * Created by liupengcheng1 on 2016/12/15.
 */
public class MyBeanPostPrecessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (StringUtils.isEmpty(car.getColor())) {
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization，设置color为黑色啦~~~");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization，将maxSpeed调整为200啦~~~");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
