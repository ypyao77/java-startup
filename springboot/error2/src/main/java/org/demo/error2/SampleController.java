package org.demo.error2;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController extends SpringBootServletInitializer {
    @RequestMapping("/exception")
    public String exception() throws Exception {
        throw new Exception("this is exception");
    }

    @RequestMapping("/custom-exception")
    public String customException() throws Exception {
        throw new CustomException("this is custom exception");
    }
}
