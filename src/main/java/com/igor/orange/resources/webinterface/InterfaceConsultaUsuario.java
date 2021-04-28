package com.igor.orange.resources.webinterface;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igor.orange.domain.DTO.UsuarioEnderecoDTO;
import com.igor.orange.services.EnderecoService;
import com.igor.orange.services.UsuarioService;

@Controller
public class InterfaceConsultaUsuario {
	
	@Autowired
	EnderecoService es;
	@Autowired
	UsuarioService us;
	
	@RequestMapping(value = "consultausuario",method=RequestMethod.GET)
	String consultausuario(Model model) {
		
		List<UsuarioEnderecoDTO> userDTO = es.findAll().stream().map(obj -> new UsuarioEnderecoDTO((us.buscar(obj.getIdusuario())), obj)).collect(Collectors.toList());
		
		model.addAttribute("userDTO",userDTO);
		
		return "consultausuario";
	}
}

	
/*
 * @RequestMapping(value = "/consultausuario",method=RequestMethod.GET) public
 * ResponseEntity<?> getall() { Model model = null;
 * 
 * List<UsuarioEnderecoDTO> userDTO = es.findAll().stream().map(obj -> new
 * UsuarioEnderecoDTO((us.buscar(obj.getIdusuario())),
 * obj)).collect(Collectors.toList());
 * 
 * model.addAttribute("userDTO",userDTO);
 * 
 * 
 * return ResponseEntity.ok().body("userDTO"); } }
 */
	