package com.lpc.other.aspect.two;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Advice
 */
@Aspect
public class SimpleAdvice {

    @Before("com.lpc.other.aspect.two.SimplePointcut.initBefore()")
    public void initInfo(){
        System.out.println("==========================");
        System.out.println("simpleAdvice initInfo ... ");
        System.out.println("==========================");
    }

}
