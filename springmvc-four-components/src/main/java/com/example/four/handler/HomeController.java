package com.example.four.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * SHAPE 1 - AbstractController.
 *
 * <p>Found by SimpleUrlHandlerMapping, invoked by SimpleControllerHandlerAdapter,
 * rendered by InternalResourceViewResolver.
 *
 * <p>AbstractController is a Template Method: it implements handleRequest, runs the
 * checks configured in the constructor, then calls handleRequestInternal.
 */
public class HomeController extends AbstractController {

    public HomeController() {
        setSupportedMethods("GET", "HEAD");   // anything else -> 405
        setCacheSeconds(0);                   // writes Cache-Control headers
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("shape", "AbstractController");
        mav.addObject("note", "Template Method: handleRequest() ran the method and cache checks, "
                + "then delegated to handleRequestInternal().");
        return mav;
    }
}
