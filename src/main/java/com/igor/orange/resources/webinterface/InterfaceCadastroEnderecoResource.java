package com.igor.orange.resources.webinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.igor.orange.domain.Endereco;
import com.igor.orange.services.EnderecoService;

@Controller
@RequestMapping
public class InterfaceCadastroEnderecoResource {

	@Autowired
	private EnderecoService es;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/cadastro_endereco", method=RequestMethod.GET)
	public String cadastroEndereco() {
		return "cadastro_endereco";
				
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/cadastro_endereco", method=RequestMethod.POST)
	public String cadastroEndereco(Endereco end) {
		
		es.insert(end);
		return "cadastro_endereco";
				
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="cadastro_endereco/{id}", method=RequestMethod.GET)
	public String retornacadastroEndereco() {
		return "cadastro_endereco";
	}
}
