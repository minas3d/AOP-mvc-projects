package com.example.four.adapter;

import com.example.four.handler.GreetingHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

/**
 * SEAM 2, implemented by us.
 *
 * <p>This is the Adapter pattern in about fifteen lines. It teaches
 * DispatcherServlet how to invoke a handler type that did not exist when
 * DispatcherServlet was written - which is the entire point of the seam.
 *
 * <p>Its second job matters as much as the first: NORMALISATION. Whatever shape
 * the handler has, the adapter hands back a ModelAndView, so everything
 * downstream sees exactly one type.
 */
public class GreetingHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        // DispatcherServlet asks every adapter this, in order, and takes the first yes.
        return handler instanceof GreetingHandler;
    }

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) {

        // Everything RequestMappingHandlerAdapter does for you, done by hand:
        // read the parameter, default it, call the handler, build the result.
        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "World";
        }

        String message = ((GreetingHandler) handler).greet(name);

        ModelAndView mav = new ModelAndView("greet");
        mav.addObject("shape", "GreetingHandler (our own interface)");
        mav.addObject("message", message);
        return mav;
    }

    /**
     * Deprecated on the interface since Spring 5.3.9 and slated to disappear.
     *
     * <p>Declared WITHOUT @Override on purpose, so this class compiles whether or
     * not the method is still declared on HandlerAdapter in your Spring version.
     */
    @SuppressWarnings("deprecation")
    public long getLastModified(HttpServletRequest request, Object handler) {
        return -1;
    }
}
