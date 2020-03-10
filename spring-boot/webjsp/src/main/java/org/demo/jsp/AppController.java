package org.demo.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AppController {
    @RequestMapping(value = {"/", "/jsp"})
    public ModelAndView jsp(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }
}
