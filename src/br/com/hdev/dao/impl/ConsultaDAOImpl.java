package br.com.hdev.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hdev.dao.ConsultaDAO;
import br.com.hdev.entity.Consulta;
import br.com.hdev.entity.Medico;

/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * responsável por implementar as funcionalidades da interface ConsultaDAO
 * 
 * @author HDEV
 *
 */
public class ConsultaDAOImpl extends DAOImpl<Consulta, Integer> implements
		ConsultaDAO {

	/**
	 * @param em
	 *            - Parâmetro do EntityManager, responsável pela ligação com o
	 *            banco
	 */
	public ConsultaDAOImpl(EntityManager em) {
		super(em);
	}

	/**
	 * Implementação do método listarPorNome declarado na interface ConsultaDAO
	 */
	@Override
	public List<Consulta> listarPorNome(Medico medico) {
		return em
				.createQuery(
						"from Consulta c where upper(c.medico.nome) like upper(:m)",
						Consulta.class).setParameter("m", "%" + medico + "%")
				.getResultList();
	}

	/**
	 * Implementação do método listar declarado na interface ConsultaDAO
	 */
	@Override
	public List<Consulta> listar() {

		return em.createQuery("from Consulta", Consulta.class).getResultList();

	}

	/**
	 * Implementação do método listarPorTipoDeMedico declarado na interface
	 * ConsultaDAO
	 */
	@Override
	public List<Consulta> listarPorTipoDeMedico(String tipo) {

		return em
				.createQuery("from Consulta c where c.medico.tipo =:t ",
						Consulta.class).setParameter("t", tipo).getResultList();
	}

	/**
	 * Implementação do método listarPorNome declarado na interface
	 * ConsultaDAO
	 */
	@Override
	public List<Consulta> listarPorNome(String nome) {
		return em
				.createQuery("from Consulta c where c.medico.nome =:n ",
						Consulta.class).setParameter("n", nome).getResultList();
	}

}
