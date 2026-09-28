package com.example.plumbing.web;

import com.example.plumbing.service.GreetingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController {
    private final GreetingService greetingService;

    public TestController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    protected ModelAndView handleRequestInternal (HttpServletRequest request,  HttpServletResponse response)
    {   ModelAndView mav = new ModelAndView("test");
        mav.addObject("Name " ,"nametestttt");
        mav.addObject("id", "1111111111111111");
        return mav;

    }

}

