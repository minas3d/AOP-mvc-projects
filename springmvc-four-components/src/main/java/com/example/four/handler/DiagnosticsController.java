package com.example.four.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists the three strategy lists DispatcherServlet built at startup, in the exact
 * order it will consult them.
 *
 * <p>Seams 1, 2 and 4 are all the same shape: a List, sorted by order, first match
 * wins. This page just makes those lists visible.
 */
public class DiagnosticsController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mav = new ModelAndView("diagnostics");
        mav.addObject("mappings", namesOf(HandlerMapping.class));
        mav.addObject("adapters", namesOf(HandlerAdapter.class));
        mav.addObject("resolvers", namesOf(ViewResolver.class));
        return mav;
    }

    /** Every bean of the given type, sorted the way DispatcherServlet sorts them. */
    private List<String> namesOf(Class<?> type) {

        List<Object> beans = new ArrayList<>(obtainApplicationContext().getBeansOfType(type).values());
        AnnotationAwareOrderComparator.sort(beans);

        List<String> names = new ArrayList<>();
        for (Object bean : beans) {
            names.add(bean.getClass().getSimpleName());
        }
        return names;
    }
}
