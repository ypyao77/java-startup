package org.demo.hello.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class BookService {
    private static Logger log = LoggerFactory.getLogger(BookService.class);

    final private Random rand = new Random();

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.api.sleep}")
    private String serviceApiSleep;

    private void sleep() {
        int ms = rand.nextInt(Integer.parseInt(this.serviceApiSleep));
        try {
            log.info("sleep " + ms + "ms");
            Thread.sleep(ms); //暂停，每一秒输出一次
        }catch (InterruptedException e) {
            return;
        }
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        this.sleep();

        return this.restTemplate.getForObject("http://hello-ribbon/list", String.class);
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
