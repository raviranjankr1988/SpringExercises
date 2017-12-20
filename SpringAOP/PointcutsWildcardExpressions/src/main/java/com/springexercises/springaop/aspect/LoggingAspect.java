package com.springexercises.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    //@Before("execution(public String com.springexercises.springaop.model.Circle.getName())")  //getName for circle class
    @Before("allGetters()")  //all get method
    public void LoggingAdvice() {
        System.out.println("LoggingAdvice method called");
    }

    @Before("allGetters()")
    public void SecondAdvice() {
        System.out.println("SecondAdvice method called");
    }

    @Pointcut("execution(* get*())")
    public void allGetters(){}
}
