package com.igor.orange.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.igor.orange.domain.Endereco;
import com.igor.orange.domain.Usuario;
import com.igor.orange.feignClient.ViaCep;
import com.igor.orange.repositories.CadastroEnderecoRepository;
import com.igor.orange.repositories.CadastroUsuarioRepository;
import com.igor.orange.services.exceptions.ObjectNotFoundException;



@Service
public class EnderecoService {

	@Autowired
	private CadastroEnderecoRepository repo;
	@Autowired
	private CadastroUsuarioRepository repouser;
	@Autowired
	private ViaCep viacep;
	
	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Endereco.class.getName()));
	}
	
	public Endereco buscarviausuario(Integer i) {	
		
		Optional<Endereco> obj = repo.findByIdusuario(i);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Endereco nao encontrado para o usuario: " + i + ", Tipo: " + Endereco.class.getName()));
	}
		
	public Endereco insert(Endereco end) {
		
		
		
		if(end.getIdusuario() == null){
			throw new DataIntegrityViolationException("Dados inválidos, preencher campo idusuário!");
		}
		else {
			
			Usuario usuario = repouser.getOne(end.getIdusuario());			
			

			Optional<Usuario> u = repouser.findById(usuario.getPk_usuario());
			
			
			if(u.isPresent()) {
			
				if(!(end.getNumero().isBlank())) {

			Endereco end2 = end;
			end = viacep.buscaEndereco(end.getCep());
		
			try {
					end.setIdusuario(end2.getIdusuario());
					end.setComplemento(end2.getComplemento()); 
					end.setNumero(end2.getNumero());
					end.setUsuario(usuario); end.setPk_endereco(null);
				  
				  return repo.save(end); 
				
			} catch (Exception e) {
				throw new DataIntegrityViolationException("Dados inválidos!");
			}	
				}
				else
					throw new DataIntegrityViolationException("Dados inválidos, preencher campo numero!");
			
			}
			else 
				throw new ObjectNotFoundException("Usuário inexistente!");
		}
		}

	
	@GetMapping
	public List<Endereco> findAll() {
		return repo.findAll();
	}
	

}
