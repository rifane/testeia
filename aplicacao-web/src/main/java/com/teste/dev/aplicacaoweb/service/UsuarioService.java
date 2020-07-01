package com.teste.dev.aplicacaoweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.teste.common.to.UsuarioTO;

@Component
public class UsuarioService implements UserDetailsService {
	@Value("${user.api.url}${user.api.findbylogin}")
	private String USERAPI_FINDBYLOGIN;
	
	@Override
	public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
		RestTemplate rest = new RestTemplate();
		
		ResponseEntity<UsuarioTO> responseEntity = null;
		try {
			responseEntity = rest.getForEntity(USERAPI_FINDBYLOGIN+userLogin, UsuarioTO.class);			
		} catch (Exception e) {
			throw new RuntimeException("Error accessing User api");
		}
		UsuarioTO usuarioTO = responseEntity != null ? responseEntity.getBody() : null;
		
		if(usuarioTO == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(usuarioTO.getAdmin()) {
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
		} else {
			authorities.add(new SimpleGrantedAuthority("USER"));
		}
		
		User user = new User(usuarioTO.getLogin(), usuarioTO.getPassword(),
				authorities);
		
		return user;
	}

}
