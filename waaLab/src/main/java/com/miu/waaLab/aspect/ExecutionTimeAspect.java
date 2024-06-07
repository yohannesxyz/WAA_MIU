//package com.miu.waaLab.aspect;
//
//
//
//
//import com.miu.waaLab.repository.LoggerRepo;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Aspect
//@Component
//public class ExecutionTimeAspect {
//    @Autowired
//    private LoggerRepo loggerRepo;
//
//    @Around("@annotation(com.miu.waaLab.aspect.ExecutionTime)")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object proceed = joinPoint.proceed();
//        long executionTime = System.currentTimeMillis() - start;
//
//        Date now = new Date();
//        String operation = joinPoint.getSignature().toShortString();
//        Logger logger = new Logger(null, now, now, "test", operation + " executed in " + executionTime + "ms");
//        loggerRepo.save(logger);
//
//        return proceed;
//
//    }
//}