package com.igor.orange.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.igor.orange.domain.Endereco;

@FeignClient(url="https://viacep.com.br/ws/", name="viacep")
public interface ViaCep {
	

	@GetMapping("{cep}/json")
	Endereco buscaEndereco(@PathVariable("cep") String cep);
	
}

