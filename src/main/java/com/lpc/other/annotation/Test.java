package com.lpc.other.annotation;

import java.lang.reflect.Method;

/**
 * Created by liupengcheng1 on 2016/12/30.
 */
public class Test {

    public static void main(String[] args) {
        Class clazz = AnnoService.class; // 得到AnnoService对应的Class对象
        Method[] methods = clazz.getDeclaredMethods(); // 得到AnnoService的Method数组
        for (Method method : methods) {
            NeedTest needTest = method.getAnnotation(NeedTest.class); // 获取方法上标注的注解对象
            if (needTest.value()) {
                System.out.println(method.getName() + "()需要测试！");
            } else {
                System.out.println(method.getName() + "()不需要测试！");
            }
        }
    }

}
