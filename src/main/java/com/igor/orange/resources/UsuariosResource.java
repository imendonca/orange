package com.igor.orange.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igor.orange.domain.Usuario;
import com.igor.orange.services.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuariosResource {

	@Autowired
	private UsuarioService us;
	

	@RequestMapping()
	public List<Usuario> getall() {
		return us.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		
		Usuario obj = us.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}	
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario usuario){
		usuario = us.insert(usuario);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/usuario/{id}").buildAndExpand(usuario.getPk_usuario()).toUri();
	return ResponseEntity.created(uri).build();
	}
}
