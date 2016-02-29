package br.com.hdev.dao;

import java.util.List;

import br.com.hdev.entity.Medico;

/**
 * Inteface que define as seguintes funcionalidades do Médico(CRUD, LOGIN,
 * BUSCAS)
 * 
 * @author HDEV
 *
 * @param <Medico>   - Classe da Entidade
 *          
 * @param <Integer> - Classe do Tipo da chave primária
 *            
 */
public interface MedicoDAO extends DAO<Medico, Integer> {

	/**
	 * Método responsável por buscar o login e senhas cadastrados no sistema
	 * 
	 * @param login (login do médico logado no sistema)          
	 * @param senha (senha do médico logado no sistema)         
	 * @return retorna true se for encontrado no banco login e senha compatíveis
	 *         com o que foi digitado, e false se o login e senha estiverem
	 *         incorretos.
	 */
	boolean logar(String login, String senha);

	/**
	 * Método responsável por buscar o login e senhas cadastrados no sistema .
	 * 
	 * @param login (login do médico logado no sistema)
	 * @param senha (senha do médico logado no sistema)
	 * @return retorna um objeto médico para ser validado na sessão em caso de
	 *         login.
	 */
	Medico buscarPorLogin(String login, String senha);

	/**
	 * Método responsável por efetuar uma busca aos médicos cadastrados.
	 * 
	 * @return retorna uma lista de médicos cadastrados
	 * 
	 * */
	List<Medico> listar();

}
