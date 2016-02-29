package br.com.hdev.dao;

import br.com.hdev.exceptions.DBCommitException;
import br.com.hdev.exceptions.IdNotFoundException;


/**
 * Inteface que define as funcionalidades 
 * genéricas do DAO (CRUD)
 * 
 * @author HDEV
 *
 * @param <T> - Classe da Entidade
 * @param <K> - Classe do Tipo da chave primária
 */
public interface DAO<T,K> {

	void create(T entity) throws DBCommitException;
	void update(T entity) throws DBCommitException;
	void delete(K id) throws DBCommitException, 
								IdNotFoundException;
	T findById(K id);
	
}
