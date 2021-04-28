package com.igor.orange.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
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
		Optional<Usuario> cpf = repo.findByCpf(usuario.getCpf());
		Optional<Usuario> email = repo.findByEmail(usuario.getEmail());
		
		if(cpf.isEmpty() && email.isEmpty()) {
			if(!(usuario.getCpf().isBlank() || usuario.getDataNasc().isBlank() || usuario.getEmail().isBlank() || usuario.getNome().isBlank())) {
				
			try {
				usuario.setPk_usuario(null);
				return repo.save(usuario);
				
			} catch (Exception e) {
				throw new DataIntegrityViolationException("Dados inválidos!");
			}
			}
			else
				throw new DataIntegrityViolationException("Dados inválidos!");

		}
		else
			throw new DuplicateKeyException("CPF ou EMAIL já existente na base");
		
	}
	
	@GetMapping
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
}
