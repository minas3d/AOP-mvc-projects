package com.Example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Component
@ComponentScan("com.Example")
public class LogingHandler {
    //private static final Log log = LogFactory.getLog(LogingHandler.class);

    @Before("com.Example.Comonpath.serviceLayer()")
    public void logBefore(JoinPoint jp){
        System.out.println("before methode "+  jp.getSignature().getName());

    }
    @AfterReturning(
            pointcut = "execution(* com.Example.CoustmmerDetails.*(..))",
             returning = "result")

    public void logAfter(JoinPoint jp,Object result){

         System.out.println("Sucsess After methode  "+  jp.getSignature().getName() +" result is " + result );

    }
    @After("execution(* com.Example.CoustmmerDetails.*(..))")
    public void after(JoinPoint jp){
        System.out.println("finish method  "+  jp.getSignature().getName());

    }
    @AfterThrowing(
            pointcut = "execution(* com.Example.CoustmmerDetails.*(..))",
            throwing = "ex")
    public void infinaly(JoinPoint jp, Exception ex){
        System.out.println("ERROR in " + jp.getSignature() + ": " +
         ex.getMessage());

    }
//    @Around("execution(* com.Example.CoustmmerDetails.*(..))")
//    public void methodaround(ProceedingJoinPoint ppj)
//    throws Throwable{
//        //
//        System.out.println("START: " + ppj.getSignature());
//        Object res = ppj.proceed();
//        System.out.println("END: " + ppj.getSignature().getName() + " took ");
//
//    }
}
