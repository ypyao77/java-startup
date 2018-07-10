package org.demo.jsp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /*
    @RequestMapping(value = "/index.do")
    public ModelAndView indexDo(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/greeting?name=IndexDo");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/greeting?name=Index");
    }
    */
}
