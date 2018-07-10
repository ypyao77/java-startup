package org.demo.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public String hello(String name) {
        return "/index";
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexDo(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/index");
    }
}
