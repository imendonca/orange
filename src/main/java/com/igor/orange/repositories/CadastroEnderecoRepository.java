package com.igor.orange.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.orange.domain.Endereco;

public interface CadastroEnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}