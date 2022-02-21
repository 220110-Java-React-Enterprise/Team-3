package com.revature.project2.aspects;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ErrorLoggingAspect {

    Logger log = LoggerFactory.getLogger(ErrorLoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.revature.project2.*.*(..)))", throwing = "e")
    public void logException(JoinPoint jp, Throwable e) {
        log.error("An exception has been thrown in " + jp.getSignature().getName() + " ()", e);
        log.error("Cause : " + e.getCause());
    }

}
