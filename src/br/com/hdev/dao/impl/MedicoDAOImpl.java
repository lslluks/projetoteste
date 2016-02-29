package br.com.hdev.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hdev.dao.MedicoDAO;
import br.com.hdev.entity.Medico;
/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * responsável por implementar as funcionalidades da interface MedicoDAO
 * 
 * @author HDEV
 *
 */

public class MedicoDAOImpl extends DAOImpl<Medico,Integer> implements MedicoDAO{
	/**
	 * @param em  -Parâmetro do EntityManager, responsável pela ligação com o banco      
	 */
	public MedicoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implementação da funcionalidade "logar" instanciada na interface MedicoDAO
	 */
	@Override
	public boolean logar(String login, String senha) {
		try {
			em.createQuery("from Medico m where m.login = "
				+ ":l and m.senha = :s")
				.setParameter("l", login).setParameter("s", senha)
				.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * Implementação da funcionalidade "buscarPorLogin" instanciada na interface MedicoDAO
	 */
	@Override
	public Medico buscarPorLogin(String login, String senha) {
			return em.createQuery("from Medico m where m.login = "
				+ ":l and m.senha = :s",Medico.class)
				.setParameter("l", login)
				.setParameter("s", senha).getSingleResult();
	
	}
	/**
	 * Implementação da funcionalidade "listar" instanciada na interface MedicoDAO
	 */
	@Override
	public List<Medico> listar() {
		return em.createQuery("from Medico",Medico.class)
				.getResultList();
	}

}
