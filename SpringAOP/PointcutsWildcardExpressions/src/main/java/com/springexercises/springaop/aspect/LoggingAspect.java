package com.springexercises.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    //@Before("execution(public String com.springexercises.springaop.model.Circle.getName())")  //getName for circle class
    @Before("execution(* get*())")  //all get method
    public void LoggingAdvice() {
        System.out.println("LoggingAdvice method called");
    }

    @Before("execution(* get*())")
    public void SecondAdvice() {
        System.out.println("SecondAdvice method called");
    }
}
