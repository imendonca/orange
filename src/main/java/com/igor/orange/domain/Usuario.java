package com.igor.orange.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer pk_usuario;
	
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
	
	@OneToMany(mappedBy = "usuario")
	private List<Endereco> enderecos = new ArrayList<>();
	

	public Usuario() {
		
	}

	public Usuario(Integer pk_usuario, String nome, String email, String cpf, String dataNasc) {
		super();
		this.pk_usuario = pk_usuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	

	public Integer getPk_usuario() {
		return pk_usuario;
	}

	public void setPk_usuario(Integer pk_usuario) {
		this.pk_usuario = pk_usuario;
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
	
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk_usuario == null) ? 0 : pk_usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (pk_usuario == null) {
			if (other.pk_usuario != null)
				return false;
		} else if (!pk_usuario.equals(other.pk_usuario))
			return false;
		return true;
	}
	
	
}
