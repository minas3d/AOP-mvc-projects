package com.Example;

import aj.org.objectweb.asm.commons.Method;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    ApplicationContext context =  new AnnotationConfigApplicationContext(LogingHandler.class);
    CoustmmerDetails customer = context.getBean(CoustmmerDetails.class);
    public void testCoustmer (){
        customer.Name("mina ")  ;
    }
}
