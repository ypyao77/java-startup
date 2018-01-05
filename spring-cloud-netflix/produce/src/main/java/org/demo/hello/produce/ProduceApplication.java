package org.demo.hello.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduceApplication.class, args);
	}
}
