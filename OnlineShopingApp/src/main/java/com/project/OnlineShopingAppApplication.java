package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class OnlineShopingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopingAppApplication.class, args);
	}

	
}
