package com.Example;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class CachingAspect {

    private final Map<String, Object> cash =new ConcurrentHashMap<>();
    @Around("@annotation(Cacheableme)")
    public Object cashee(ProceedingJoinPoint ppj) throws Throwable{
        String key = ppj.getSignature().getName() + Arrays.toString(ppj.getArgs());
    if (cash.containsKey(key)){
        System.out.println("cash hit " + key );
        return cash.get(key);
   }
   Object res = ppj.proceed();
    cash.put(key,res);
    return res;
    }
}
