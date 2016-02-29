package br.com.hdev.dao;

import java.util.List;

import br.com.hdev.entity.Consulta;
import br.com.hdev.entity.Medico;

/**
 * 
 * @author HDEV Inteface que define as funcionalidades da Consulta (CRUD) e
 *         funcionalidades de buscas específicas.
 * @param <Consulta>  - Classe da Entidade
 *           
 * @param <Integer> - Classe do Tipo da chave primária
 *            
 */

public interface ConsultaDAO extends DAO<Consulta, Integer> {

	/**
	 * 
	 * @param medico
	 * @return retorna uma lista de consultas de acordo com o nome do médico
	 */
	List<Consulta> listarPorNome(Medico medico);

	/**
	 * 
	 * @return retorna uma lista de consultas cadastradas.
	 */
	List<Consulta> listar();

	/**
	 * 
	 * @param tipo (tipo do médico)
	 *            
	 * @return retorna uma lista de consultas de acordo com o tipo do médico que
	 *         está logado no sistema.
	 */
	List<Consulta> listarPorTipoDeMedico(String tipo);
	
	/**
	 * 
	 * @param tipo (médico)
	 *            
	 * @return retorna uma lista de consultas de acordo com o médico que
	 *         está logado no sistema.
	 */
	List<Consulta> listarPorNome(String nome);

}
