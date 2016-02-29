package br.com.hdev.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hdev.dao.AgendaDAO;
import br.com.hdev.entity.Agenda;

/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * responsável por implementar as funcionalidades da interface AgendaDAO
 * 
 * @author HDEV
 *@deprecated
 */

public class AgendaDAOImpl extends DAOImpl<Agenda, Integer> implements
		AgendaDAO {

	/**
	 * @param em  -Parâmetro do EntityManager, responsável pela ligação com o
	 *            banco
	 *           
	 */
	public AgendaDAOImpl(EntityManager em) {
		super(em);

	}

	/**
	 * Implementação do método declarado "listar()" presente na interface
	 * AgendaDAO
	 */
	@Override
	public List<Agenda> listar() {
		return em.createQuery("from Agenda", Agenda.class).getResultList();
	}

	/**
	 * Implementação do método declarado "searchByAgendamento()" presente na
	 * interface AgendaDAO
	 */
	@Override
	public List<Agenda> searchByAgendamento(String tipo) {
		return em
				.createQuery(
						"Select a.agendamentos.consulta.data, a.agendamentos.consulta.hora "
								+ "from Agenda a where "
								+ "TO_DATE(SYSDATE,'DD/MM/YYYY') >= TO_DATE(a.agendamentos.consulta.data, 'DD/MM/YYYY')"
								+ "and a.medico.tipo :t", Agenda.class)
				.setParameter("f", tipo).getResultList();

	}

}
