package org.demo.hello.consume;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumeController {
    private final Logger logger = Logger.getLogger(getClass());

    @Resource
    private ConsumeService consumeService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(String token) {
        return consumeService.hello(token);
    }
}
