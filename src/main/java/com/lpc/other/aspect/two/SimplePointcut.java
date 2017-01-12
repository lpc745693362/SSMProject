package com.lpc.other.aspect.two;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Pointcut
 */
@Aspect
public class SimplePointcut {

    @Pointcut("execution(* com.lpc.other.aspect.two..*.*(..))")
    public void initBefore(){
    }

}
