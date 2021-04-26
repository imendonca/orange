package com.igor.orange.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igor.orange.domain.Endereco;
import com.igor.orange.services.EnderecoService;

@RestController
@RequestMapping(value="/endereco")
public class EnderecosResource {

	@Autowired
	private EnderecoService es;
	

	@RequestMapping()
	public List<Endereco> getall() {
		return es.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		
		Endereco obj = es.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Endereco end){
		end = es.insert(end);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/endereco/{id}").buildAndExpand(end.getPk_endereco()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	
}
