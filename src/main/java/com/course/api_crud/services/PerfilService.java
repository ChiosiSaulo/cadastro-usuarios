package com.course.api_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.api_crud.entities.Perfil;
import com.course.api_crud.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;
	
	/**
	 * Retorna uma lista contendo todos os perfis cadastrados no sistema.
	 *
	 * @return Lista de perfis cadastrados.
	 */
	
	public List<Perfil> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Busca um usuário pelo ID informado.
	 *
	 * @param id Identificador único do perfil.
	 * @return O perfil correspondente ao ID fornecido.
	 * @throws NoSuchElementException Se o perfil não for encontrado.
	 */
	
	public Perfil findById(Long id) {
		Optional<Perfil> perfil = repository.findById(id);
		return perfil.get();
	}
	
	/**
	 * Insere um novo usuário no banco de dados.
	 *
	 * @param Perfil Objeto contendo os dados do perfil a ser cadastrado.
	 * @return O perfil salvo com o ID gerado.
	 */
	
	public Perfil insert(Perfil perfil) {
		return repository.save(perfil);
	}
	
	/**
	 * Exclui um perfil do banco de dados com base no ID informado.
	 *
	 * @param id Identificador único do perfil a ser excluído.
	 * @throws EmptyResultDataAccessException Se o ID não existir no banco de dados.
	 */
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Atualiza os dados de um perfil existente com base no ID informado.
	 *
	 * @param id Identificador único do perfil a ser atualizado.
	 * @param Perfil Objeto contendo os novos dados do perfil.
	 * @return O perfil atualizado e salvo no banco de dados.
	 * @throws EntityNotFoundException Se o usuário com o ID fornecido não for encontrado.
	 */
	
	public Perfil update(Long id, Perfil perfil) {
		Perfil perfilAtualizado = repository.getReferenceById(id);
		updateData(perfilAtualizado, perfil);
		return repository.save(perfilAtualizado);
	}

	/**
	 * Atualiza os dados de um usuário existente com as informações fornecidas.
	 *
	 * @param PerfilAtualizado Usuário que será atualizado.
	 * @param Perfil Objeto contendo os novos dados do usuário.
	 */
	
	private void updateData(Perfil perfilAtualizado, Perfil perfil) {
		perfilAtualizado.setNome(perfil.getNome());
	}
}
