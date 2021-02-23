package com.management.salessystem.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {
    static final LOGGER = LoggerFactory.getLogger(LoggingAspect.class)

    @AfterReturning('@annotation(Logging) && execution(public * *(..))')
    static void trace(JoinPoint joinPoint) {
        final args = joinPoint.args.toList()
        LOGGER.info("An update occurs with the following details:\n\t-sale id: ${args[0]}\n\t-request: ${args[1]}")
    }
}
