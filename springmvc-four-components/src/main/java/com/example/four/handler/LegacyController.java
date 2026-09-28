package com.example.four.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * SHAPE 2 - the raw Controller interface, the original 2004 handler shape.
 *
 * <p>Routed by BeanNameUrlHandlerMapping: this bean is declared with name="/legacy",
 * and the bean NAME is the URL. It must be name= and not id=, because an XML id
 * cannot contain a slash.
 *
 * <p>Look at how much is manual below. All of it is what
 * RequestMappingHandlerAdapter was built to delete.
 */
public class LegacyController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) {

        String raw = req.getParameter("times");
        int times;
        try {
            times = (raw == null || raw.isBlank()) ? 3 : Integer.parseInt(raw);
        } catch (NumberFormatException ex) {
            times = 3;                  // no @RequestParam, no conversion, no defaulting
        }
        times = Math.max(0, Math.min(times, 20));

        ModelAndView mav = new ModelAndView("legacy");
        mav.addObject("shape", "Controller (interface)");
        mav.addObject("times", times);
        mav.addObject("echo", "ping ".repeat(times));
        return mav;
    }
}
