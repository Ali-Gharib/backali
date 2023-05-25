package com.test.indata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@EnableSwagger2
public class IndataApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndataApplication.class, args);
	}

}
