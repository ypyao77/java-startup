package org.demo.hello.feign;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class ConsumeController {
    private final Logger logger = Logger.getLogger(getClass());

    @Resource
    private ConsumeService consumeService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query() {
        return consumeService.hello();
    }
}
