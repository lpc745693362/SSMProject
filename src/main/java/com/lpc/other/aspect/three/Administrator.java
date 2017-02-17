package com.lpc.other.aspect.three;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 桃林管理员
 */
@Aspect
public class Administrator {

    /**
     * 切点
     */
    @Pointcut("execution(* com.lpc.other.aspect.three.Monkey.stealPeaches(..))")
    private void watchMonkey() {
    }

    @Before("watchMonkey()")
    public void foundMonkey() {
        System.out.println("【管理员】看到猴子进入桃林了！");
    }

    @AfterReturning("watchMonkey() && args(name)")
    public void catchMonkey(String name) {
        System.out.println("【管理员】逮到并拷问出了猴子的名字：" + name);
    }

}
