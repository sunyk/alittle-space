package com.sunyk.springbootcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);
	}
}
