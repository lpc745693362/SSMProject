package com.lpc.other.one;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Bean的生命周期
 */
public class BeanLifeCycle {

    private static void LifeCycleInBeanFactory() {

        // 装配配置文件并启动容器
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        // 向容器中注册MyBeanPostPrecessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostPrecessor());

        // 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 第一次从容器中获取car，将触发容器实例化该bean，这将引发Bean生命周期方法的调用
        Car car = (Car) beanFactory.getBean("car");
        car.introduce();
        car.setColor("红色");

        // 第二次从容器中获取car，直接从缓存池中获取
        Car car0 = (Car) beanFactory.getBean("car");

        System.out.println("car == car0：" + (car == car0));

        // 关闭容器
        ((ConfigurableBeanFactory) beanFactory).destroySingletons();

    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }

}
