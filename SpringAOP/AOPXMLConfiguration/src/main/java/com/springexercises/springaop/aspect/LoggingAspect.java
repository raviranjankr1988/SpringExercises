package com.springexercises.springaop.aspect;

import com.springexercises.springaop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

public class LoggingAspect {

    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        Object obj=null;
        try {
            System.out.println("myAroundAdvice before proceedingJoinPoint.proceed()");
            obj = proceedingJoinPoint.proceed();
            System.out.println("myAroundAdvice after proceedingJoinPoint.proceed()");
        } catch (Throwable throwable) {
            System.out.println("myAroundAdvice exception thrown");
            throwable.printStackTrace();
        } finally {
            System.out.println("myAroundAdvice finally excuted");
        }
        return obj;
    }
}
