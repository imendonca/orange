package com.igor.orange.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.igor.orange.domain.Endereco;
import com.igor.orange.domain.Usuario;
import com.igor.orange.repositories.CadastroEnderecoRepository;
import com.igor.orange.repositories.CadastroUsuarioRepository;
import com.igor.orange.services.exceptions.ObjectNotFoundException;



@Service
public class EnderecoService {

	@Autowired
	private CadastroEnderecoRepository repo;
	private CadastroUsuarioRepository repouser;
	
	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Endereco.class.getName()));
	}
		
	public Endereco insert(Endereco end) {
		
		end.setPk_endereco(null);
		return repo.save(end);
	}
	
	@GetMapping
	public List<Endereco> findAll() {
		return repo.findAll();
	}
}
