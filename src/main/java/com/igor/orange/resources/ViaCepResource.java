package com.igor.orange.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igor.orange.domain.Endereco;
import com.igor.orange.feignClient.ViaCep;

@Service
@RequestMapping(value="/cep")
public class ViaCepResource {
	
	@Autowired
	private ViaCep viacep;
	
	@RequestMapping(value="/{cep}", method=RequestMethod.GET)
	public ResponseEntity<Endereco> getCep(@PathVariable("cep") String cep){
		
		
        Endereco endereco = viacep.buscaEndereco(cep);
        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build(); 
	}

}
