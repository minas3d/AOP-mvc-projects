package com.example.plumbing.web;

import com.example.plumbing.service.GreetingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {

        this.greetingService = greetingService;
    }
 @Controller
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("message", "Here the message");
        mav.addObject("name", greetingService.greet("Hamada"));
        return mav;
    }
}
