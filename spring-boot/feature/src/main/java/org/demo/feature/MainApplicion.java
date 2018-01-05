package org.demo.feature;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.ServletComponentScan;

// MyBatis 支持
@MapperScan("org.demo.feature.dao")
// filter 支持
@ServletComponentScan(basePackages="org.demo.feature.web")
@SpringBootApplication
public class MainApplicion {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplicion.class, args);
	}

}