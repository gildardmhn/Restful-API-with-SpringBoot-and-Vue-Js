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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ufc.br.model.Contato;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<Contato>> listaContatoUsuario(@PathVariable("idUsuario") Usuario usuario){
		List<Contato> contatos = contatoService.listaContatodoUsuario(usuario);
		return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Contato> buscarContatoPorID(@PathVariable("id") Contato contato){
		return new ResponseEntity<Contato>(contato, HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato,@RequestParam("usuario") Usuario usuario){
		contatoService.salvarContato(contato, usuario);
		return new ResponseEntity<Contato>(contato, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirContato(@PathVariable("id") Contato contato){ 
		contatoService.excluiContato(contato.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
