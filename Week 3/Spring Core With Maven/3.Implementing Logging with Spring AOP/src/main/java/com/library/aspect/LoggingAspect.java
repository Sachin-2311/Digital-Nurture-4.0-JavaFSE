package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // continue to target method

        long end = System.currentTimeMillis();
        System.out.println("[LOG] Method " + joinPoint.getSignature().getName() +
                           " executed in " + (end - start) + " ms");
        return result;
    }
}
