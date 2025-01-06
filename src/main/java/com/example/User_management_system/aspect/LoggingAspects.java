package com.example.User_management_system.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspects {

    @Before("execution(* com.example.User_management_system.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint){
        System.out.println("method called :"+ joinPoint.getSignature().getName());
    }
}
