package org.demo.log4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppTask {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppTask.class);
    }
}
