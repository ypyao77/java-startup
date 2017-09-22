package org.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/message").setViewName("message");
        registry.addViewController("/login").setViewName("login");
        // registry.addViewController("/pic").setViewName("images/pic.jpg");
        // registry.addViewController("/404.html").setViewName("404");
        registry.addViewController("/error.html").setViewName("404");
    }
}
