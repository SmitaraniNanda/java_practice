package com.questk2.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	 // Pointcut - Defines where the advice should be applied
    @Pointcut("execution(* com.questk2.aop.service.MyService.*(..))")
    public void allMethodsPointcut() {}

    // Before Advice
    @Before("allMethodsPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before execution of: " + joinPoint.getSignature().getName());
    }

    // After Advice
    @After("allMethodsPointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After execution of: " + joinPoint.getSignature().getName());
    }

    // Around Advice - Controls method execution
    @Around("execution(* com.questk2.aop.service.MyService.calculateSum(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before calling: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // Execute the method
        System.out.println("After calling: " + joinPoint.getSignature().getName());
        return result;
    }

    // After Returning Advice - Captures returned value
    @AfterReturning(pointcut = "execution(* com.questk2.aop.service.MyService.calculateSum(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("Method " + joinPoint.getSignature().getName() + " returned: " + result);
    }

    // After Throwing Advice - Captures exceptions
    @AfterThrowing(pointcut = "execution(* com.questk2.aop.service.MyService.throwException(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName() + " - " + ex.getMessage());
    }
    
    
    
    
    /*
    @Pointcut("execution(* com.questk2.aop.service.MyService.*(..))") → Matches all methods in MyService.
    @Before → Runs before the method executes.
     @After → Runs after the method executes (regardless of success or failure).
     @Around → Controls execution, allowing modification of inputs/outputs.
     @AfterReturning → Captures return values of successful method executions.
     @AfterThrowing → Runs when a method throws an exception.
    */
    
    
    
    
    
}