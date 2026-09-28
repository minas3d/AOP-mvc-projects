package com.example.four.handler;

/** A trivial implementation of our own handler shape. */
public class PoliteGreetingHandler implements GreetingHandler {

    @Override
    public String greet(String name) {
        return "Good day to you, " + name + ".";
    }
}
