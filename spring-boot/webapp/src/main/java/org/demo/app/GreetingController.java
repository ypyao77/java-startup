package org.demo.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value = "/do")
    public ModelAndView Do(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/greeting?name=DO");
    }

    @RequestMapping(value = "/forward")
    public ModelAndView forward(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/greeting?name=FORWARD");
    }

    @RequestMapping(value = "/redirect")
    public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("redirect:/greeting?name=REDIRECT");
    }
}
