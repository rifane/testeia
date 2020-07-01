package com.teste.dev.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.teste.common.to.UsuarioTO;
import com.teste.dev.api.domain.Usuario;
import com.teste.dev.api.repository.UsuarioRepository;

@Component
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioTO> findAll() {
		Iterable<Usuario> all = usuarioRepository.findAll();
		return StreamSupport.stream(all.spliterator(), false)
			.map(u -> getUsuarioTOFromUsuario(u))
			.collect(Collectors.toList());
	}

	public UsuarioTO findById(Long id) {
		Optional<Usuario> userOpt = usuarioRepository.findById(id);
		if(userOpt.isPresent()) {
			UsuarioTO userDto = new UsuarioTO();
			BeanUtils.copyProperties(userOpt.get(), userDto);
			return userDto;
		} else {
			return null;
		}
	}

	public UsuarioTO findByLogin(String login) {
		Optional<Usuario> userOpt = usuarioRepository.findByLogin(login);
		if(userOpt.isPresent()) {
			UsuarioTO userDto = new UsuarioTO();
			BeanUtils.copyProperties(userOpt.get(), userDto);
			return userDto;
		} else {
			return null;
		}
	}
	
	public void insert(@Valid Usuario usuario) throws Exception {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		usuarioRepository.save(usuario);
	}
	
	public void update(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void delete(@NotNull Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario getUserFromUsuarioTO(UsuarioTO u) {
		Usuario user = new Usuario();
		BeanUtils.copyProperties(u, user);
		return user;
	}
	
	public UsuarioTO getUsuarioTOFromUsuario(Usuario u) {
		UsuarioTO userDto = new UsuarioTO();
		BeanUtils.copyProperties(u, userDto);
		return userDto;
	}
}
