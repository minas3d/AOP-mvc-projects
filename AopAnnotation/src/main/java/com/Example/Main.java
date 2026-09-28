package com.Example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        BeanFactory context =  new AnnotationConfigApplicationContext(LogingHandler.class);
     //CoustmmerDetails customer =context.getBean(CoustmmerDetails.class);
        Order ord =context.getBean(Order.class);
         ord.getOrder("mina");
         ord.getOrder("mina");

       // customer.Name("Mina");

    }
}
