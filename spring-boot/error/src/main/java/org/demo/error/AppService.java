package org.demo.error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.demo.error")
public class AppService {
    public static void main(String[] args) {
        SpringApplication.run(AppService.class, args);
    }
}
