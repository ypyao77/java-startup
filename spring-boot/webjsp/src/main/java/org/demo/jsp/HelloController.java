package org.demo.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/say1")
    public String say1() {
        // return "/index";
        return "/greeting/say1?name=hello.say1";
    }

    @RequestMapping(value = "/say2")
    public ModelAndView say2(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/index");
    }

    @RequestMapping("/say3")
    @ResponseBody
    public String say3() {
        return "hello, say3";
    }
}
