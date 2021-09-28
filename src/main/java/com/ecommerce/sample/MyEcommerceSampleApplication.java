package com.ecommerce.sample;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories("com.ecommerce.repositorysamples")
@EntityScan("com.ecommerce.modelsamples")
@ComponentScan("com.ecommerce.servicesamples")
@ComponentScan("com.ecommerce.controller")
@ComponentScan("com.ecommerce.websecurity.config.sample")
public class MyEcommerceSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEcommerceSampleApplication.class, args);
	}

}
