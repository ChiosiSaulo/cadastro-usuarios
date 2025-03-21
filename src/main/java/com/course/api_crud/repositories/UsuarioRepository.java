package com.course.api_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.api_crud.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
