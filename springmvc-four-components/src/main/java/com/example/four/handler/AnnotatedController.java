package com.example.four.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SHAPE 3 - the modern annotated controller.
 *
 * <p>Found by RequestMappingHandlerMapping, invoked by RequestMappingHandlerAdapter.
 *
 * <p>There is no component scan in this project: this bean is declared in XML like
 * every other one. RequestMappingHandlerMapping still finds it, because it inspects
 * every bean in the context for @Controller / @RequestMapping at TYPE level.
 *
 * <p>Compare the signature with LegacyController. The defaulting and the
 * String -> int conversion are gone; they moved into the adapter's
 * HandlerMethodArgumentResolver list.
 */
@Controller
public class AnnotatedController {

    @GetMapping("/annotated")
    public String annotated(@RequestParam(defaultValue = "42") int answer, Model model) {
        model.addAttribute("shape", "@Controller + @GetMapping");
        model.addAttribute("answer", answer);
        model.addAttribute("note",
                "The int was parsed for you by RequestParamMethodArgumentResolver.");
        return "annotated";             // a logical view name, same as every other shape
    }
}
