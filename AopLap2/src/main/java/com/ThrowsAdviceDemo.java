package com;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdviceDemo implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("ERROR: " + ex.getMessage());
    }

}
