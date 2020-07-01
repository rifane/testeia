package com.teste.dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.common.to.UsuarioTO;
import com.teste.dev.api.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/find/{id}")
	public UsuarioTO find(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@GetMapping("/findAll")
	public List<UsuarioTO> find() {
		return usuarioService.findAll();
	}

	@GetMapping("/findByLogin/{login}")
	public UsuarioTO findByLogin(@PathVariable String login) {
		return usuarioService.findByLogin(login);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody UsuarioTO usuarioTO) {
		try {
			if(usuarioTO == null) {
				throw new Exception("UsuarioTO required.");
			}
			usuarioService.insert(usuarioService.getUserFromUsuarioTO(usuarioTO));
			return new ResponseEntity<String>("User inserted!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Insert fail! Erro:"+e.getMessage(), HttpStatus.OK);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {			
			usuarioService.delete(id);
			return new ResponseEntity<String>("User deleted!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Delete fail! Erro:"+e.getMessage(), HttpStatus.OK);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody UsuarioTO usuarioTO) {
		try {
			if(usuarioTO == null) {
				throw new Exception("UsuarioTO required.");
			}
			usuarioService.update(usuarioService.getUserFromUsuarioTO(usuarioTO));
			return new ResponseEntity<String>("User updated!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Update fail! Erro:"+e.getMessage(), HttpStatus.OK);
		}
	}
}
