package com.course.api_crud.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.course.api_crud.entities.Perfil;
import com.course.api_crud.services.PerfilService;

@RestController
@RequestMapping("/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilService service;

	@GetMapping
	public ResponseEntity<List<Perfil>> findAll(){
		List<Perfil> listaPerfis = service.findAll();
		return ResponseEntity.ok().body(listaPerfis);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Perfil> findById(@PathVariable Long id){
		Perfil perfil = service.findById(id);
		return ResponseEntity.ok().body(perfil);
	}
	
	@PostMapping
	public ResponseEntity<Perfil> insert(@RequestBody Perfil perfil){
		perfil = service.insert(perfil);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(perfil.getId()).toUri();
		return ResponseEntity.created(uri).body(perfil);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Perfil> update(@PathVariable Long id, @RequestBody Perfil novoPerfil){
		Perfil perfilAtualizado = service.update(id, novoPerfil);
		return ResponseEntity.ok().body(perfilAtualizado);
	}
}
