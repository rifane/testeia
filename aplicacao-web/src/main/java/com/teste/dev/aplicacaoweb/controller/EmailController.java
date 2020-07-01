package com.teste.dev.aplicacaoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.common.to.EmailTO;
import com.teste.dev.aplicacaoweb.service.EmailProducerService;

@RestController
public class EmailController {

	@Autowired
	private EmailProducerService emailProducerService;
	
	@PostMapping("/email")
	public ResponseEntity<String> send(@RequestBody EmailTO emailTO) {
		boolean success = emailProducerService.produce(emailTO);
		if(success) {
			return new ResponseEntity<String>("Sended successfully.", HttpStatus.OK);				
		} else {
			return new ResponseEntity<String>("Not sended.", HttpStatus.OK);
		}
	}
}
