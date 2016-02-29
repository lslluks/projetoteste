package br.com.hdev.dao;

import java.util.List;

import br.com.hdev.entity.Consulta;
import br.com.hdev.entity.Medico;

/**
 * 
 * @author HDEV Inteface que define as funcionalidades da Consulta (CRUD) e
 *         funcionalidades de buscas espec�ficas.
 * @param <Consulta>  - Classe da Entidade
 *           
 * @param <Integer> - Classe do Tipo da chave prim�ria
 *            
 */

public interface ConsultaDAO extends DAO<Consulta, Integer> {

	/**
	 * 
	 * @param medico
	 * @return retorna uma lista de consultas de acordo com o nome do m�dico
	 */
	List<Consulta> listarPorNome(Medico medico);

	/**
	 * 
	 * @return retorna uma lista de consultas cadastradas.
	 */
	List<Consulta> listar();

	/**
	 * 
	 * @param tipo (tipo do m�dico)
	 *            
	 * @return retorna uma lista de consultas de acordo com o tipo do m�dico que
	 *         est� logado no sistema.
	 */
	List<Consulta> listarPorTipoDeMedico(String tipo);
	
	/**
	 * 
	 * @param tipo (m�dico)
	 *            
	 * @return retorna uma lista de consultas de acordo com o m�dico que
	 *         est� logado no sistema.
	 */
	List<Consulta> listarPorNome(String nome);

}
