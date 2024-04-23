package com.enicarthage.servicedestage.Aspect;
import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
    @Around("execution(* com.enicarthage.servicedestage..*(..))")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("{} Entering method: {} with arguments: {}", LocalDateTime.now(), name, java.util.Arrays.toString(args));
        Object result = joinPoint.proceed();
        logger.info("{} Exiting method: {}, result: {}", LocalDateTime.now(), name, result);
        return result;
    }
}
