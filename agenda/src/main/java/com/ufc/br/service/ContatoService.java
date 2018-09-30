package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Contato;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public void salvarContato(Contato contato, Usuario usuario) {
		contato.setUsuario(usuario);
		contatoRepository.save(contato);
	}
	
	public void excluiContato(Long id) {
		contatoRepository.deleteById(id);		
    }
	
	public List<Contato> listaContatodoUsuario(Usuario usuario){
		return contatoRepository.findByUsuario(usuario);
	}
	
}
