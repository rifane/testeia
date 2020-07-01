package com.teste.dev.consumoemail;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.teste.dev.consumoemail.service.ConsumoEmailService;

@Configuration
@EnableRabbit
public class RabbitConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory());
		containerFactory.setMaxConcurrentConsumers(environment.getProperty("rabbitmq.max-concurrent-consumers", Integer.class));
		return containerFactory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(environment.getProperty("rabbitmq.host"));
		connectionFactory.setPort(environment.getProperty("rabbitmq.port", Integer.class));
		connectionFactory.setUsername(environment.getProperty("rabbitmq.username"));
		connectionFactory.setPassword(environment.getProperty("rabbitmq.password"));
		return connectionFactory;
	}
	
	@Bean
	public ConsumoEmailService consumoEmailService() {
		return new ConsumoEmailService();
	}
}
