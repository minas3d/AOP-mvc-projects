package com.example.four.handler;

/**
 * SHAPE 5 - a handler type that Spring has never heard of.
 *
 * <p>This interface is ours. It is not a Controller, not an HttpRequestHandler,
 * not annotated with anything. No adapter Spring ships can invoke it.
 *
 * <p>It works anyway, because HandlerMapping returns the handler typed as Object
 * and seam 2 is pluggable: see GreetingHandlerAdapter.
 */
@FunctionalInterface
public interface GreetingHandler {
    String greet(String name);
}
