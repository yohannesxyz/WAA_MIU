package com.miu.waaLab.aspect;




import com.miu.waaLab.repository.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private LoggerRepo loggerRepo;

    @Around("@annotation(ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        LocalDate datePart = LocalDate.now();
        LocalTime timePart = LocalTime.now();

        String operation = joinPoint.getSignature().toShortString();

        Logger logger = new Logger();
        logger.setDate(datePart);
        logger.setTime(timePart);
        logger.setPrinciple(executionTime + "ms");
        logger.setOperation(operation);

        loggerRepo.save(logger);

        return proceed;

    }
}