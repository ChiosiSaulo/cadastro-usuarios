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
	
	/**
	 * Retorna uma lista contendo todos os usuários cadastrados no sistema.
	 *
	 * @return Lista de usuários cadastrados.
	 */
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Busca um usuário pelo ID informado.
	 *
	 * @param id Identificador único do usuário.
	 * @return O usuário correspondente ao ID fornecido.
	 * @throws NoSuchElementException Se o usuário não for encontrado.
	 */
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.get();
	}
	
	/**
	 * Insere um novo usuário no banco de dados.
	 *
	 * @param usuario Objeto contendo os dados do usuário a ser cadastrado.
	 * @return O usuário salvo com o ID gerado.
	 */
	
	public Usuario insert(Usuario usuario) {
		return repository.save(usuario);
	}
	
	/**
	 * Exclui um usuário do banco de dados com base no ID informado.
	 *
	 * @param id Identificador único do usuário a ser excluído.
	 * @throws EmptyResultDataAccessException Se o ID não existir no banco de dados.
	 */
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Atualiza os dados de um usuário existente com base no ID informado.
	 *
	 * @param id Identificador único do usuário a ser atualizado.
	 * @param usuario Objeto contendo os novos dados do usuário.
	 * @return O usuário atualizado e salvo no banco de dados.
	 * @throws EntityNotFoundException Se o usuário com o ID fornecido não for encontrado.
	 */
	
	public Usuario update(Long id, Usuario usuario) {
		Usuario usuarioAtualizado = repository.getReferenceById(id);
		updateData(usuarioAtualizado, usuario);
		return repository.save(usuarioAtualizado);
	}

	/**
	 * Atualiza os dados de um usuário existente com as informações fornecidas.
	 *
	 * @param usuarioAtualizado Usuário que será atualizado.
	 * @param usuario Objeto contendo os novos dados do usuário.
	 */
	
	private void updateData(Usuario usuarioAtualizado, Usuario usuario) {
		usuarioAtualizado.setNome(usuario.getNome());
		usuarioAtualizado.setEmail(usuario.getEmail());
	}
}
