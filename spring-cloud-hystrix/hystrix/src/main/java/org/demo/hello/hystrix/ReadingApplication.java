package org.demo.hello.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class ReadingApplication {

    @Autowired
    private BookService bookService;

    @RequestMapping("/read")
    public String read() {
        return bookService.readingList();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReadingApplication.class, args);
    }
}
