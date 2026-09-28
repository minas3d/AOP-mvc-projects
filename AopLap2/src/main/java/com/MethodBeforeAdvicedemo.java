package com;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodBeforeAdvicedemo implements MethodBeforeAdvice {

@Override
public void before(Method method, Object[] args, Object target) throws
        Throwable {
    System.out.println("name of method is " + method.getName() + " argument is " + Arrays.toString(args) );

}

}
