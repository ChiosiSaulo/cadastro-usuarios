package com.course.api_crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.api_crud.entities.Usuario;
import com.course.api_crud.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Saulo Chiosi", "saulo@gmail.com", "12345");
		Usuario u2 = new Usuario(null, "Raphaella Vicente", "raphaella@gmail.com", "12345");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}

}
