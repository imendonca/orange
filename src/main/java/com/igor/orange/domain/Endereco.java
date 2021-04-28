package com.igor.orange.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer pk_endereco;
	@NotNull
	private String logradouro;
	@NotNull
	private String numero;
	
	private String complemento;
	@NotNull
	private String bairro;
	@NotNull
	private String localidade;
	@NotNull
	private String uf;
	@NotNull
	private String cep;
		
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;
	
	@NotNull
	private int idusuario;
	
	public Endereco() {
		
	}

	public Endereco(Integer pk_endereco, String logradouro, String numero, String complemento, String bairro,
			String localidade, String uf, String cep, int idusuario) {
		super();
		this.pk_endereco = pk_endereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.idusuario = idusuario;
	}

	/*
	 * public String toString() { return "Endereco{" + "cep='" + cep + '\'' +
	 * ", logradouro='" + logradouro + '\'' + ", complemento='" + complemento + '\''
	 * + ", bairro='" + bairro + '\'' + ", localidade='" + localidade + '\'' +
	 * ", uf='" + uf + '\'' + '}'; }
	 */
	public Integer getPk_endereco() {
		return pk_endereco;
	}

	public void setPk_endereco(Integer pk_endereco) {
		this.pk_endereco = pk_endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getlocalidade() {
		return localidade;
	}

	public void setlocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getuf() {
		return uf;
	}

	public void setuf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk_endereco == null) ? 0 : pk_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (pk_endereco == null) {
			if (other.pk_endereco != null)
				return false;
		} else if (!pk_endereco.equals(other.pk_endereco))
			return false;
		return true;
	}

	
	
}
