package com.teste.dev.api.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.teste.dev.api.domain.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);
}
