package com.lpc.other.one;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 实现管理Bean生命周期的接口，测试Bean生命周期
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand; // 车牌号
    private String color; // 颜色
    private Integer maxSpeed; // 最高速度

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("调用Car()构造函数啦~~~");
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性啦~~~");
        this.brand = brand;
    }

    public String introduce() {
        return "Car{" + "brand='" + brand + '\'' + ", color='" + color + '\'' + ", maxSpeed=" + maxSpeed + '}';
    }

    /**
     * BeanFactoryAware接口方法
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()啦~~~");
        this.beanFactory = beanFactory;
    }

    /**
     * BeanNameAware接口方法
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBeanName()啦~~~");
        this.beanName = beanName;
    }

    /**
     * InitializingBean接口方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()啦~~~");
    }

    /**
     * DisposableBean接口方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()啦~~~");
    }

    /**
     * 通过<bean>的init-method属性指定的初始化方法
     */
    public void myInit(){
        System.out.println("调用init-method所指定的myInit()，将maxSpeed设置为300~~~");
        this.maxSpeed = 300;
    }

    /**
     * 通过<bean>的destory-method属性指定的初始化方法
     */
    public void myDestory(){
        System.out.println("调用destory-method所指定的myDestory()啦~~~");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }
}
