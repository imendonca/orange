package com.igor.orange.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.orange.domain.Endereco;

@Repository
public interface CadastroEnderecoRepository extends JpaRepository<Endereco, Integer>{
	
	public Optional<Endereco> findByLogradouro(String logradouro);
	
	public Optional<Endereco> findByNumero(String numero);
	
	public Optional<Endereco> findByIdusuario(int idusuario);
}