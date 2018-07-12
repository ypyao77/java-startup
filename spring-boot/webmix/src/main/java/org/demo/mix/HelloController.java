package org.demo.mix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @RequestMapping(value = {"/say1"})
    public String say1(String name) {
        return "/greeting?name=Hello.SAY1";
    }

    @RequestMapping(value = {"/say2", "say3", "say4"})
    public ModelAndView say2() {
        return new ModelAndView("/greeting?name=Hello.SAY2");
    }

    @RequestMapping(value = {"/", "main"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = {"jsp"})
    public ModelAndView jsp(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("hello");
    }
}
