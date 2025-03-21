package com.course.api_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.api_crud.entities.Usuario;
import com.course.api_crud.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> usu = repository.findById(id);
		return usu.get();
	}
	
	public Usuario insert(Usuario usu) {
		return repository.save(usu);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario usu) {
		Usuario entidade = repository.getReferenceById(id);
		updateData(entidade, usu);
		return repository.save(entidade);
	}

	private void updateData(Usuario entidade, Usuario usu) {
		entidade.setName(usu.getName());
		entidade.setEmail(usu.getEmail());
		
	}
}
