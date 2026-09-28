package com.Example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Order {
    @Cacheableme
    public String getOrder(String id) {

        System.out.println("Get order from database: " + id);

        return "Order " + id;
    }
}
