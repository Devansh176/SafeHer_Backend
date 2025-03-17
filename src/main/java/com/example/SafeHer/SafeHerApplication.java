package com.example.SafeHer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entity")
public class SafeHerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SafeHerApplication.class, args);
	}
}
