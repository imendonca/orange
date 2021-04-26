package com.igor.orange.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igor.orange.domain.Endereco;
import com.igor.orange.repositories.CadastroEnderecoRepository;

@Controller
@RequestMapping
public class InterfaceCadastroEnderecoResource {

	@Autowired
	private CadastroEnderecoRepository cer;
	
	@RequestMapping(value = "/cadastro_endereco", method=RequestMethod.GET)
	public String cadastroEndereco() {
		return "cadastro_endereco";
				
	}
	
	@RequestMapping(value = "/cadastro_endereco", method=RequestMethod.POST)
	public String cadastroEndereco(Endereco end) {
		
		cer.save(end);
		return "redirect:cadastro_endereco";
				
	}
	
}
