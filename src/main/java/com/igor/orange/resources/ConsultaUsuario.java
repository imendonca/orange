package com.igor.orange.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.igor.orange.domain.DTO.UsuarioEnderecoDTO;
import com.igor.orange.services.EnderecoService;
import com.igor.orange.services.UsuarioService;

@RestController
@RequestMapping(value="/consulta_usuario")
public class ConsultaUsuario {
	@Autowired
	private UsuarioService us;
	@Autowired
	private EnderecoService es;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getall() {
		List<UsuarioEnderecoDTO> userDTO = es.findAll().stream().map(obj -> new UsuarioEnderecoDTO((us.buscar(obj.getIdusuario())), obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(userDTO);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		List<UsuarioEnderecoDTO> userDTO = es.findAll().stream().map(obj -> new UsuarioEnderecoDTO((us.buscar(obj.getIdusuario())), obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(userDTO);
		
	}	
	
	
}
