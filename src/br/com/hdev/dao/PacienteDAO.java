package br.com.hdev.dao;




/**
 * Inteface que define as seguintes funcionalidades do Paciente(CRUD, LOGIN, BUSCAS)
 * @author HDEV
 *
 * @param <Paciente> - Classe da Entidade
 * @param <Integer> - Classe do Tipo da chave prim�ria
 */

import java.util.List;

import br.com.hdev.entity.Paciente;

public interface PacienteDAO extends DAO<Paciente,Integer>{

	/**
	 * 
	 * @param login (login do paciente cadastrado)
	 * @param senha (senha do paciente cadastrado)
	 * @return retorna um objeto Paciente ao encontrar seu login e senha, assim validando-o na sess�o.
	 */
	Paciente buscarPorLogin(String login, String senha);
	
	/**
	 * M�todo respons�vel por buscar o login e senhas cadastrados no sistema
	 * 
	 * @param login (login do paciente )
	 * @param senha (senha do paciente )
	 * @return retorna true se for encontrado no banco login e 
	 * senha compat�veis com o que foi digitado, e false se o login e senha estiverem incorretos.
	 */
	boolean logar(String login, String senha);
	
	/**
	 * 
	 * @param nome (nome do Paciente)
	 * @return retorna um paciente encontrado conforme o nome digitado.
	 */
	List<Paciente> buscarPorNome(String nome);
	
	/**
	 * 
	 * @param nome (nome do Paciente)
	 * @return retorna uma lista de pacientes cadastrados conforme o 
	 * usu�rio digitar suas letras iniciais compat�veis(autocomplete)
	 */
	List<String> autoCompletePorNome(String nome);
	
	/**
	 * 
	 * @return retorna uma lista de Pacientes cadastrados no sistema.
	 */
	List<Paciente> listar();

}
