package br.com.hdev.dao;

import java.util.List;

import br.com.hdev.entity.Agenda;

/**
 * Inteface que define as funcionalidades da Agenda (CRUD)
 * 
 * @author HDEV
 *
 * @param <Agenda>
 *            - Classe da Entidade
 * @param <Integer>
 *            - Classe do Tipo da chave prim�ria
 *@deprecated
 */
public interface AgendaDAO extends DAO<Agenda, Integer> {

	/**
	 * M�todo para listagem de agendas.
	 * 
	 * @return retorna uma lista de agendas cadastradas
	 */

	List<Agenda> listar();

	/**
	 * 
	 * M�todo que procura uma agenda por agendamentos cadastrados
	 * 
	 * @param tipo
	 * @return retorna uma lista de agendas
	 */
	List<Agenda> searchByAgendamento(String tipo);
}
