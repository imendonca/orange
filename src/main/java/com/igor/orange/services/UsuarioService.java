package com.igor.orange.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.igor.orange.domain.Usuario;
import com.igor.orange.repositories.CadastroUsuarioRepository;
import com.igor.orange.services.exceptions.ObjectNotFoundException;



@Service
public class UsuarioService {

	@Autowired
	private CadastroUsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getName()));
	}
		
	public Usuario insert(Usuario usuario) {
		Optional<Usuario> obj = repo.findByCpf(usuario.getCpf());
		if(obj.isPresent()) {
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Usuário já existente: " + usuario.getNome() + ", CPF: " + usuario.getCpf()));
		}
		obj = repo.findByEmail(usuario.getEmail());
		if(obj.isPresent()) {
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Usuário já existente: " + usuario.getNome() + ", Tipo: " + usuario.getEmail()));
		}
		
		usuario.setPk_usuario(null);
		return repo.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
}
