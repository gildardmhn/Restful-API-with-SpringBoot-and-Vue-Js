package com.ufc.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.br.model.Contato;
import com.ufc.br.model.Usuario;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

	public List<Contato> findByUsuario(Usuario usuario);
}
