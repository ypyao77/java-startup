package org.demo.hello.consume;

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

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String consumer() {
        return consumeService.hello();
    }
}
