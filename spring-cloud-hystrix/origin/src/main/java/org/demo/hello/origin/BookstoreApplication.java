package org.demo.hello.origin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class BookstoreApplication {
	private static Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	@RequestMapping(value = "/list")
	public String readingList(){
		return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	}

	@RequestMapping(value = "/")
	public String home() {
		log.info("Access /");
		return "Hi!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
