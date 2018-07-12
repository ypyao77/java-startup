package org.demo.mix;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {
    @RequestMapping(value = {"/greeting"})
    public String greeting(@RequestParam(value = "name", defaultValue = "DEFAULT") String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value = {"/do"})
    public ModelAndView Do(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/greeting?name=DO");
    }
}
