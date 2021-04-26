package com.igor.orange.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.orange.domain.Usuario;

public interface CadastroUsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByCpf(String cpf);
	
	public Optional<Usuario> findByEmail(String email);
}