package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void excluiUsuario(Long id) {
		usuarioRepository.deleteById(id);		
    }
	
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.getOne(id);
    }
	
	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll(); 
    }

}
