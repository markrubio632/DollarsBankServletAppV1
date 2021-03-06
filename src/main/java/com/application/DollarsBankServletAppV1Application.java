package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages="com")
@EntityScan(basePackages="com.model")
@EnableJpaRepositories("com.repository")
public class DollarsBankServletAppV1Application {

	public static void main(String[] args) {
		SpringApplication.run(DollarsBankServletAppV1Application.class, args);
	}

}
