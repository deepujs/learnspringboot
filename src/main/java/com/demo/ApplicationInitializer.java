package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationInitializer {

	Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInitializer.class, args);
	}


}
