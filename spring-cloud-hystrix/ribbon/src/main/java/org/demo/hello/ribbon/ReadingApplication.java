package org.demo.hello.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
@RibbonClient(name = "hello-ribbon", configuration = RibbonConfiguration.class)
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
