package org.demo.hello.consume.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${producer.service.name}")
    private String producerServiceName;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String consumer() {
        return restTemplate.getForEntity("http://" + this.producerServiceName + "/hello", String.class).getBody();
    }
}
