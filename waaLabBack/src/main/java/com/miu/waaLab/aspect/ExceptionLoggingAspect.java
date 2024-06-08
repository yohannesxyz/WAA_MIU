package com.miu.waaLab.aspect;

import com.miu.waaLab.entity.ExceptionLogger;
import com.miu.waaLab.repository.ExceptionLoggerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionLoggingAspect {

    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepo;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)") // Adjust the pointcut expression as needed
    public void requestMappingMethods() {}

    @Around("requestMappingMethods()")
    public Object logExceptions(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Throwable ex) {
            logException(joinPoint, ex);
            throw ex;
        }
    }

    private void logException(ProceedingJoinPoint joinPoint, Throwable ex) {
        LocalDate datePart = LocalDate.now();
        LocalTime timePart = LocalTime.now();
        String operation = joinPoint.getSignature().toShortString();
        String exceptionType = ex.getClass().getName();

        ExceptionLogger exceptionLogger = new ExceptionLogger();
        exceptionLogger.setDate(datePart);
        exceptionLogger.setTime(timePart);
        exceptionLogger.setPrinciple("Exception occurred");
        exceptionLogger.setOperation(operation);
        exceptionLogger.setExceptionType(exceptionType);

        exceptionLoggerRepo.save(exceptionLogger);
    }
}

