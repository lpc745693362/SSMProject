package com.lpc.other.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liupengcheng1 on 2016/12/30.
 */
@Retention(RetentionPolicy.RUNTIME) // 注解的保留期限
@Target(ElementType.METHOD) // 方法注解
public @interface NeedTest {
    // 声明注解成员
    boolean value() default true;
}
