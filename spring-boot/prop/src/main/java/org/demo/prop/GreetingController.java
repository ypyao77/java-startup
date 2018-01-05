package org.demo.prop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController("RestController")
@PropertySource("classpath:jdbc.properties")
@PropertySource("classpath:redis.properties")
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Value("${rest.host}")
    private String restHost;

    @Value("${rest.url}")
    private String restUrl;

    @Value("${jdbc.mysql.host}")
    private String mysqlHost;

    @Value("${jdbc.redis.host}")
    private String redisHost;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("rest.host = " + this.restHost + ", rest.url = " + this.restUrl);

        return new Greeting(counter.incrementAndGet(), String.format(template, name), restHost, restUrl, mysqlHost, redisHost);
    }
}
