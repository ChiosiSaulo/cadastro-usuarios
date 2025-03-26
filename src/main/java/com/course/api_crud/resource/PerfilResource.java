package com.course.api_crud.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
