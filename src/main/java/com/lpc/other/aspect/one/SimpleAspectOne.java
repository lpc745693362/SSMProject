package com.lpc.other.aspect.one;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 该Aspect中Pointcut和Advice混杂在一起
 */
@Aspect
public class SimpleAspectOne {

    @Before("execution(* com.lpc.other.aspect.one..*.*(..))")
    public void doBeforeInit() {
        System.out.println("========================");
        System.out.println("AOP: do before init");
        System.out.println("========================");
    }

}
