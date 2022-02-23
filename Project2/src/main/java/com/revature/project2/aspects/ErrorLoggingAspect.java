/*
package com.revature.project2.aspects;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * @Author Jeffrey
 * AOP Error Logging for all files
 */
/*
@Aspect
@Component
public class ErrorLoggingAspect {

    Logger log = LoggerFactory.getLogger(ErrorLoggingAspect.class);

    @AfterThrowing(pointcut = "within(com.revature.project2.controllers.*) && !within(com.revature.project2.controllers.CORSFilter)", throwing = "e")
    public void logException(JoinPoint jp, Throwable e) {
        log.error("An exception has been thrown in " + jp.getSignature().getName() + "()", e);
        log.error("Cause : " + e.getCause());
    }

}
*/