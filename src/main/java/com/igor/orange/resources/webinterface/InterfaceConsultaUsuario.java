package com.igor.orange.resources.webinterface;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.igor.orange.domain.DTO.UsuarioEnderecoDTO;
import com.igor.orange.services.EnderecoService;
import com.igor.orange.services.UsuarioService;

@Controller
public class InterfaceConsultaUsuario {
	
	@Autowired
	EnderecoService es;
	@Autowired
	UsuarioService us;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "consultausuario",method=RequestMethod.GET)
	String consultausuario(Model model) {
		
		List<UsuarioEnderecoDTO> userDTO = es.findAll().stream().map(obj -> new UsuarioEnderecoDTO((us.buscar(obj.getIdusuario())), obj)).collect(Collectors.toList());
		
		model.addAttribute("userDTO",userDTO);
		
		return "consultausuario";
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "consultausuario/{$}",method=RequestMethod.GET)
	String consultausuarioqualquer(Model model) {
		
		List<UsuarioEnderecoDTO> userDTO = es.findAll().stream().map(obj -> new UsuarioEnderecoDTO((us.buscar(obj.getIdusuario())), obj)).collect(Collectors.toList());
		
		model.addAttribute("userDTO",userDTO);
		
		return "consultausuario";
	}

}