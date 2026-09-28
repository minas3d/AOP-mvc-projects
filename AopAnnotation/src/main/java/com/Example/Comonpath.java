package com.Example;

import org.aspectj.lang.annotation.Pointcut;

public class Comonpath{
    @Pointcut("execution(* com.Example.CoustmmerDetails.*(..))")
    public void serviceLayer() {}

}