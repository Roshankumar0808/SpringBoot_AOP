package com.AspectOrientedProgramming.AspectOrientedProgramming.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.AspectOrientedProgramming.AspectOrientedProgramming.services.Impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("Before orderPackage called from LoggingAspect Kind,{}",joinPoint.getKind());
        log.info("Before orderPackage called from LoggingAspect Signature,{}",joinPoint.getSignature());

    }

    @Before("within(com.AspectOrientedProgramming.AspectOrientedProgramming.services.Impl.*)")
    public void beforeOrderPackage(){
        log.info("Before orderPackage called from LoggingAspect Kind");
        log.info("Before orderPackage called from LoggingAspect Signature");

    }

    @Before("within(com.AspectOrientedProgramming.AspectOrientedProgramming..*)")
    public void beforeOrderPackageforAll(){
        log.info("Before orderPackage called from LoggingAspect Kind");
        log.info("Before orderPackage called from LoggingAspect Signature");

    }

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactionalAnnotation(){
        log.info("Before Transactional Annotation");
     //   log.info("Before orderPackage called from LoggingAspect Signature");
    }

    @Before("@annotation(com.AspectOrientedProgramming.AspectOrientedProgramming.aspects.MyLogging)")
    public void beforeLoggingAnnotation(){
        log.info("Before Logging Annotation");
        //   log.info("Before orderPackage called from LoggingAspect Signature");
    }

    @Before("myLoggingAndAopMethod()")
    public void beforeLoggingAnnotationWithPointcut(){
        log.info("Before Logging Annotation With Poincut");
        //   log.info("Before orderPackage called from LoggingAspect Signature");
    }

    @After("myLoggingAndAopMethod()")
    public void afterLoggingAnnotationWithPointcut(){
        log.info("After Logging Annotation With Poincut");
        //   log.info("Before orderPackage called from LoggingAspect Signature");
    }

   @Pointcut("@annotation(com.AspectOrientedProgramming.AspectOrientedProgramming.aspects.MyLogging)&&within(com.AspectOrientedProgramming.AspectOrientedProgramming..*)")
    public void myLoggingAndAopMethod(){

   }

}
