package br.com.hdev.dao;

import java.util.List;

import br.com.hdev.entity.Medico;

/**
 * Inteface que define as seguintes funcionalidades do M�dico(CRUD, LOGIN,
 * BUSCAS)
 * 
 * @author HDEV
 *
 * @param <Medico>   - Classe da Entidade
 *          
 * @param <Integer> - Classe do Tipo da chave prim�ria
 *            
 */
public interface MedicoDAO extends DAO<Medico, Integer> {

	/**
	 * M�todo respons�vel por buscar o login e senhas cadastrados no sistema
	 * 
	 * @param login (login do m�dico logado no sistema)          
	 * @param senha (senha do m�dico logado no sistema)         
	 * @return retorna true se for encontrado no banco login e senha compat�veis
	 *         com o que foi digitado, e false se o login e senha estiverem
	 *         incorretos.
	 */
	boolean logar(String login, String senha);

	/**
	 * M�todo respons�vel por buscar o login e senhas cadastrados no sistema .
	 * 
	 * @param login (login do m�dico logado no sistema)
	 * @param senha (senha do m�dico logado no sistema)
	 * @return retorna um objeto m�dico para ser validado na sess�o em caso de
	 *         login.
	 */
	Medico buscarPorLogin(String login, String senha);

	/**
	 * M�todo respons�vel por efetuar uma busca aos m�dicos cadastrados.
	 * 
	 * @return retorna uma lista de m�dicos cadastrados
	 * 
	 * */
	List<Medico> listar();

}
