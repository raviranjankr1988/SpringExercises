package com.springexercises.springaop.aspect;

import com.springexercises.springaop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    //@Before("execution(public String com.springexercises.springaop.model.Circle.getName())")  //getName for circle class
    @Before("allCircleMethods()")  //all get method
    public void LoggingAdvice(JoinPoint joinPoint) {

        //System.out.println(joinPoint.toString());
        //System.out.println(joinPoint.getTarget());
        Circle circle = (Circle) joinPoint.getTarget();
    }

//    @Before("args(String)")
//    public void StringArgumentMethods() {
//        System.out.println("A method with String argument has been called");
//    }

    @Before("args(name)")
    public void StringArgumentMethods(String name) {
        System.out.println("A method with String argument has been called for name : "+name + " before method call");
    }

    @After("args(name)") //this executes even on failure of function call
    public void StringArgumentMethodsaftr(String name) {
        System.out.println("A method with String argument has been called for name : "+name + " after method call");
    }

    @AfterReturning(pointcut = "args(name)",returning = "returnString")
    public void StringArgumentMethodsaftronsuccess(String name,String returnString) {
        System.out.println("A method with String argument has been called for name : "+name + " AfterReturning method call");
        System.out.println("The Ouput value is  " + returnString);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void StringArgumentMethodsaftronThrowingEx(String name,Exception ex) {
        System.out.println("A method with String argument has been called for name : "+name + " AfterThrowing method call");
    }

    @Around("allGetters()")
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

    @Around("@annotation(com.springexercises.springaop.aspect.Loggable)")
    public void myAroundAdviceannotation(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("myAroundAdviceannotation before proceedingJoinPoint.proceed()");
            proceedingJoinPoint.proceed();
            System.out.println("myAroundAdviceannotation after proceedingJoinPoint.proceed()");
        } catch (Throwable throwable) {
            System.out.println("myAroundAdviceannotation exception thrown");
            throwable.printStackTrace();
        } finally {
            System.out.println("myAroundAdviceannotation finally excuted");
        }
    }

    @Pointcut("execution(* get*())")
    public void allGetters(){}

    @Pointcut("within(com.springexercises.springaop.model.Circle)")
    public void allCircleMethods(){}
}
