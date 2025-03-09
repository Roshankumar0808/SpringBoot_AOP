package com.AspectOrientedProgramming.AspectOrientedProgramming.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAscpectV2 {

    @Before("allServiceMethodPointCut()")
    public void beforeServiceMethodCalls(JoinPoint joinPoint){
     log.info("Before advice method call,{}",joinPoint.getSignature());
    }

    @After("allServiceMethodPointCut()")
    public void afterServiceMethodCalls(JoinPoint joinPoint){
        log.info("After advice method call,{}",joinPoint.getSignature());
    }

    @AfterReturning(value = "allServiceMethodPointCut()",returning="returnedObj")
    public void afterReturningServiceMethodCalls(JoinPoint joinPoint ,Object returnedObj){
        log.info("After Returing advice method call,{}",joinPoint.getSignature());
        log.info("After Returing advice method call final value,{}",returnedObj);

    }

    @AfterThrowing("allServiceMethodPointCut()")
    public void afterThrowingServiceMethodCalls(JoinPoint joinPoint){
        log.info("After throwing advice method call,{}",joinPoint.getSignature());
    }

    @Around("allServiceMethodPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        Long startTime=System.currentTimeMillis();
        Object returnedValue=proceedingJoinPoint.proceed();
        Long endTime=System.currentTimeMillis();
        Long diff=endTime-startTime;
        log.info("Time take for {} is {}",proceedingJoinPoint.getSignature(),diff);
        return returnedValue;
    }

    @Pointcut("execution(* com.AspectOrientedProgramming.AspectOrientedProgramming.services.Impl.*.*(..))")
    public void allServiceMethodPointCut(){

    }
}
