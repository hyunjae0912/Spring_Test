package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SpringProject13Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProject13Application.class, args);
	}

}
