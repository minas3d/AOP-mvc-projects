package com.example.four.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.io.PrintWriter;
import java.util.Map;

/**
 * SEAM 4, implemented by us.
 *
 * <p>The View interface has two methods and no idea what a "view name" is.
 * Naming is ViewResolver's job; rendering is this class's job. That separation is
 * why this bean can be a shared singleton: it holds no request state.
 *
 * <p>Registered as a bean named "plainTextView", so BeanNameViewResolver finds it
 * when a handler returns that string. No prefix, no suffix, no file on disk.
 */
public class PlainTextView implements View {

    @Override
    public String getContentType() {
        return "text/plain;charset=UTF-8";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        res.setContentType(getContentType());
        PrintWriter out = res.getWriter();

        out.println("Rendered by PlainTextView - a View bean, not a file.");
        out.println("Resolved by BeanNameViewResolver, because the handler returned");
        out.println("the string \"plainTextView\" and a bean with that name exists.");
        out.println();
        out.println("The model DispatcherServlet handed to render():");
        out.println("------------------------------------------------");

        if (model == null || model.isEmpty()) {
            out.println("(empty)");
        } else {
            model.forEach((k, v) -> out.println("  " + k + " = " + v));
        }

        out.println();
        out.println("Note what did NOT happen: no prefix, no suffix, no JSP, no forward.");
        out.println("InternalResourceViewResolver was never consulted, because");
        out.println("BeanNameViewResolver has a lower order and answered first.");
    }
}
