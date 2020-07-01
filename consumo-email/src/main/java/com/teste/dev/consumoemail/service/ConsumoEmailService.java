package com.teste.dev.consumoemail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.common.to.EmailTO;

public class ConsumoEmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumoEmailService.class);
	
	@RabbitListener(containerFactory="rabbitListenerContainerFactory", queues = "${queue.email.name}")
	public void consumeEmailQueue(String message) {
		try {
			EmailTO emailTO = new ObjectMapper().readValue(message, EmailTO.class);
			LOGGER.info(message);
			LOGGER.info(emailTO.getMessage());
		} catch (Exception e) {
			LOGGER.error("Email consume fail. "+e.getMessage(), e);
		}
	}
}
