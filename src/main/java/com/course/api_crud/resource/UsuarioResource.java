package com.course.api_crud.resource;

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

import com.course.api_crud.entities.Usuario;
import com.course.api_crud.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	/**
	 * Retorna uma lista de todos os usuários cadastrados.
	 *
	 * @return ResponseEntity contendo a lista de usuários e status HTTP 200 (OK).
	 */
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Busca um usuário pelo ID informado.
	 *
	 * @param id Identificador único do usuário.
	 * @return ResponseEntity contendo o usuário encontrado e status HTTP 200 (OK).
	 * @throws ResourceNotFoundException Se o usuário não for encontrado.
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	/**
	 * Insere um novo usuário no sistema.
	 *
	 * @param usuario Objeto contendo os dados do usuário a ser cadastrado.
	 * @return ResponseEntity contendo o usuário criado e status HTTP 201 (Created).
	 */
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
		usuario = service.insert(usuario);
		return ResponseEntity.created(null).body(usuario);
	}
	
	/**
	 * Exclui um usuário com base no ID informado.
	 *
	 * @param id Identificador único do usuário a ser excluído.
	 * @return ResponseEntity com status HTTP 204 (No Content) se a exclusão for bem-sucedida.
	 * @throws ResourceNotFoundException Se o usuário não for encontrado.
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Atualiza os dados de um usuário existente com base no ID informado.
	 *
	 * @param id  Identificador único do usuário a ser atualizado.
	 * @param obj Objeto contendo os novos dados do usuário.
	 * @return ResponseEntity contendo o usuário atualizado e status HTTP 200 (OK).
	 * @throws ResourceNotFoundException Se o usuário não for encontrado.
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		Usuario usuarioAtualizado = service.update(id, obj);
		return ResponseEntity.ok().body(usuarioAtualizado);
	}
}
