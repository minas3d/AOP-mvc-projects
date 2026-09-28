package com;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodInterceptorDemo implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

       long start = System.currentTimeMillis();
       System.out.println("START: " + invocation.getMethod().getName());
        try {
            return invocation.proceed();
        }
        finally {
            System.out.println("END: took " + (System.currentTimeMillis()- start) + "ms");
        }
    }
}
