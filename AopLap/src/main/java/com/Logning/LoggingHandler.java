package com.Logning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingHandler implements InvocationHandler {
    Object obj ;

    public LoggingHandler(Object obj) {
        this.obj = obj;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("LOG: calling " + method.getName());
        System.out.println("LOG: arguments = " + Arrays.toString(args));
        Object result =method.invoke(obj,args);
       // System.out.println("LOG: return value = " + obj);
        System.out.println("LOG: finished " + method.getName());

        return result;
    }
}
