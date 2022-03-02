package com.bolsadeideas.springboot.web.app.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Diego");
		usuario.setApellido("Rosales");
		usuario.setEmail("dr00837@citi.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Diego", "Rosales", "dr00837@citi.com"),
				new Usuario("Cesar", "Rosales", "cr84747@citi.com"),
				new Usuario("Rubi",  "Lopez",   "rl00840@citi.com"),
				new Usuario("Jade",  "Lopez",   "rl54646@citi.com"));

		return usuarios;
	}

}
