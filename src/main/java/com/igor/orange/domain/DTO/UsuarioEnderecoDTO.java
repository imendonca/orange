
  package com.igor.orange.domain.DTO;
  
  import java.io.Serializable;
  
  import com.igor.orange.domain.Endereco; import
  com.igor.orange.domain.Usuario; import com.sun.istack.NotNull;
  
  public class UsuarioEnderecoDTO implements Serializable{ private static final
  long serialVersionUID = 1L;
  
  @NotNull private String nomeusuario;
  
  @NotNull private String logradouro;
  
  @NotNull private String numero;
  
  private String complemento;
  
  @NotNull private String bairro;
  
  @NotNull private String localidade;
  
  @NotNull private String uf;
  
  @NotNull private String cep;
  
  
  public UsuarioEnderecoDTO(Usuario nome, Endereco end) { super();
  this.nomeusuario = nome.getNome(); this.logradouro = end.getLogradouro();
  this.numero = end.getNumero(); this.complemento = end.getComplemento();
  this.bairro = end.getBairro(); this.localidade = end.getlocalidade(); this.uf
  = end.getuf(); this.cep = end.getCep(); }
  
  
  public UsuarioEnderecoDTO() {
  
  }
  
  
  public String getNomeusuario() { return nomeusuario; }
  
  
  public void setNomeusuario(String nome) { this.nomeusuario = nome; }
  
  
  public String getLogradouro() { return logradouro; }
  
  
  public void setLogradouro(String logradouro) { this.logradouro = logradouro;
  }
  
  
  public String getNumero() { return numero; }
  
  
  public void setNumero(String numero) { this.numero = numero; }
  
  
  public String getComplemento() { return complemento; }
  
  
  public void setComplemento(String complemento) { this.complemento =
  complemento; }
  
  
  public String getBairro() { return bairro; }
  
  
  public void setBairro(String bairro) { this.bairro = bairro; }
  
  
  public String getLocalidade() { return localidade; }
  
  
  public void setLocalidade(String localidade) { this.localidade = localidade;
  }
  
  
  public String getUf() { return uf; }
  
  
  public void setUf(String uf) { this.uf = uf; }
  
  
  public String getCep() { return cep; }
  
  
  public void setCep(String cep) { this.cep = cep; }
  
  
  
  }
 