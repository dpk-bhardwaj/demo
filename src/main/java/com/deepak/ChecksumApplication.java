package com.deepak;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ChecksumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChecksumApplication.class, args);
	}
}
