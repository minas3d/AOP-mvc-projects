package com;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Proxy;

public class Main {
    static void main() {
        InventoryService bl = new InventoryServiceImpl();
        ProxyFactory factory = new ProxyFactory(bl);

        factory.addAdvice(new AfterReturningAdviceDemo());
      //  factory.addAdvice(new MethodBeforeAdvicedemo());
        factory.addAdvice(new MethodInterceptorDemo());
        factory.addAdvice(new ThrowsAdviceDemo());
        InventoryService proxy =(InventoryService) factory.getProxy();

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("reserveStock");
        Advisor advisor =  new DefaultPointcutAdvisor(pointcut, new MethodBeforeAdvicedemo());
        factory.addAdvisor(advisor);



        System.out.println( proxy.checkStock("mina"));
       System.out.println(   proxy.reserveStock("mina ",506236230));

    }
}
