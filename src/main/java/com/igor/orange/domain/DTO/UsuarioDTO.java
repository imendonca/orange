package com.igor.orange.domain.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.igor.orange.domain.Usuario;
import com.sun.istack.NotNull;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String nome;
	
	@Email
	@NotNull
	@Column(unique=true)
	private String email;
	
	@CPF
	@NotNull
	@Column(unique=true)
	private String cpf;
	
	@NotNull
	private String dataNasc;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario u) {
		this.nome = u.getNome();
		this.email = u.getEmail();
		this.cpf = u.getCpf();
		this.dataNasc = u.getDataNasc();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
