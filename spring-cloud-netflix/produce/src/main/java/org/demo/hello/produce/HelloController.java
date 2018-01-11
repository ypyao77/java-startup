package org.demo.hello.produce;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());

    @Value("${orig.source.name}")
    private String origSourceName;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/")
    public String home() {
        logger.info("Access /");
        return "Hi!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        List<String> services = client.getServices();
        logger.info("/hello, services:" + services.toString());
        return "[" + this.getCurrTime() + "] (" + this.origSourceName + ") (" + UUID.randomUUID().toString() + ") Hello world." + services.toString();
    }

    private String getCurrTime() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
}
