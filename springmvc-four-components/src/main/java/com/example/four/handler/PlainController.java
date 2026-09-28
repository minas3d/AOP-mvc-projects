package com.example.four.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Same handler shape as HomeController. The ONLY difference is the string it
 * returns as a view name.
 *
 * <p>"home" falls through BeanNameViewResolver (no such bean) and lands on
 * InternalResourceViewResolver -> a JSP.
 * "plainTextView" matches a View bean, so BeanNameViewResolver answers first and
 * InternalResourceViewResolver is never consulted.
 *
 * <p>One word changed the rendering technology. That is seam 4 working.
 */
public class PlainController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mav = new ModelAndView("plainTextView");
        mav.addObject("shape", "AbstractController");
        mav.addObject("resolvedBy", "BeanNameViewResolver");
        mav.addObject("hint", "change the view name to \"home\" and you get a JSP instead");
        return mav;
    }
}
