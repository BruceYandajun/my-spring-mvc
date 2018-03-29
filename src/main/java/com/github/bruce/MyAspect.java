package com.github.bruce;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;

@Aspect
public class MyAspect {

    @Value("${hystrix.switch}")
    private Boolean hystrixSwitch;

    @Around("execution(* com.github.bruce..*.*(..))")
    public void service(ProceedingJoinPoint joinPoint) {
        if (hystrixSwitch) {
            System.out.println("open hystrix switch");
        }
        try {
            joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("service");
    }
}
