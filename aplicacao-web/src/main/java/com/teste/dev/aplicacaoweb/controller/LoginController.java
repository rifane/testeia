package com.teste.dev.aplicacaoweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/login")
	public ResponseEntity<String> login() {
		ResponseEntity<String> response = new ResponseEntity<String>("Loged in!", HttpStatus.OK);
		return response;
	}
}
