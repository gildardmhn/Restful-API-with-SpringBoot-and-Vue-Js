package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.br.model.Usuario;
import com.ufc.br.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
		usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Usuario> buscarUsuarioByid(@PathVariable ("id") Usuario usuario){
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);		
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> usuarios = usuarioService.listarUsuario();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Usuario usuario){
		usuarioService.excluiUsuario(usuario.getId());
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	

}
