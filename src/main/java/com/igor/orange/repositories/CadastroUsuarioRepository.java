package com.igor.orange.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.orange.domain.Usuario;

@Repository
public interface CadastroUsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByCpf(String cpf);
	
	public Optional<Usuario> findByEmail(String email);
	
	
}