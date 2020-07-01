package com.teste.dev.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ApiUsuarioAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsuarioAppApplication.class, args);
	}

}
