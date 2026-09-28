package com.example.plumbing.service;


// Lives in the ROOT application context -- created by ContextLoaderListener,
// NOT by DispatcherServlet. Controllers (in the web context) can see this
// bean because the web context's parent is the root context.
public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
