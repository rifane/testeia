package com.teste.dev.aplicacaoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableConfigurationProperties
@EnableWebSecurity
@EnableRedisHttpSession
@SpringBootApplication
public class AplicacaoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoWebApplication.class, args);
	}

}
