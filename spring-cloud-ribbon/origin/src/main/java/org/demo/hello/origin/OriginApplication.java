package org.demo.hello.origin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@RestController
@SpringBootApplication
public class OriginApplication {

	private static Logger log = LoggerFactory.getLogger(OriginApplication.class);

	@RequestMapping(value = "/hello")
	public String hello() {
		log.info("Access /hello");

		List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
		Random rand = new Random();

		int randomNum = rand.nextInt(greetings.size());
		return greetings.get(randomNum);
	}

	@RequestMapping(value = "/")
	public String home() {
		log.info("Access /");
		return "Hi!";
	}

	public static void main(String[] args) {
		SpringApplication.run(OriginApplication.class, args);
	}
}
