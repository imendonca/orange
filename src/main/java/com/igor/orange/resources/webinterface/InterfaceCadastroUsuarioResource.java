package com.igor.orange.resources.webinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.igor.orange.domain.Usuario;
import com.igor.orange.services.UsuarioService;

@Controller
@RequestMapping
public class InterfaceCadastroUsuarioResource {
	
	@Autowired
	private UsuarioService us;

	@RequestMapping(value = "/cadastro_usuario", method=RequestMethod.GET)
	public String cadastro_usuario() {
		return "cadastro_usuario";
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/cadastro_usuario", method=RequestMethod.POST)
	public String cadastro_usuario(Usuario usuario) {
		
		us.insert(usuario);
		return "/cadastro_usuario";
	}
	
}
