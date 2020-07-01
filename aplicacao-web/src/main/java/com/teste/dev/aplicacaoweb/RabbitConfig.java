package com.teste.dev.aplicacaoweb;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(environment.getProperty("rabbitmq.host"));
		connectionFactory.setPort(environment.getProperty("rabbitmq.port", Integer.class));
		connectionFactory.setUsername(environment.getProperty("rabbitmq.username"));
		connectionFactory.setPassword(environment.getProperty("rabbitmq.password"));
		return connectionFactory;
	}
	
	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(rabbitConnectionFactory());
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory());
		return rabbitTemplate;
	}
	
	@Bean
	public Queue emailQueue() {
		return new Queue(environment.getProperty("queue.email.name"), true);
	}
}
