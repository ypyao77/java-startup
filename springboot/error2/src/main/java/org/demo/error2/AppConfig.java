package org.demo.error2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;;

@EnableAutoConfiguration
@Configuration
@ComponentScan("org.demo.error2")
public class AppConfig extends WebMvcConfigurerAdapter {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppConfig.class, args);
    }
}
