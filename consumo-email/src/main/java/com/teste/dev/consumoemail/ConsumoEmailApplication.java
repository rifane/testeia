package com.teste.dev.consumoemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ConsumoEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoEmailApplication.class, args);
	}

}
