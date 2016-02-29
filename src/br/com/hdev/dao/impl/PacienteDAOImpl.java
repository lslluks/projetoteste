package br.com.hdev.dao.impl;



import java.util.List;

import javax.persistence.EntityManager;

import br.com.hdev.dao.PacienteDAO;
import br.com.hdev.entity.Paciente;

/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * respons�vel por implementar as funcionalidades da interface PacienteDAO
 * 
 * @author HDEV
 *
 */
public class PacienteDAOImpl extends DAOImpl<Paciente,Integer> implements PacienteDAO{

	/**
	 * @param em  -Par�metro do EntityManager, respons�vel pela liga��o com o banco      
	 */
	public PacienteDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implementa��o da funcionalidade "logar" instanciada na interface PacienteDAO
	 */
	@Override
	public boolean logar(String login, String senha) {
		try {
			em.createQuery("from Paciente p where p.login = "
				+ ":l and p.senha = :s")
				.setParameter("l", login).setParameter("s", senha)
				.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Implementa��o da funcionalidade "buscarPorNome" instanciada na interface PacienteDAO
	 */
	@Override
	public List<Paciente> buscarPorNome(String nome) {
	
		return em.createQuery("from Paciente p where "
				+ "upper(p.nome) like upper(:n)",Paciente.class)
				.setParameter("n","%"+nome+"%").getResultList();
	}

	/**
	 * Implementa��o da funcionalidade "autoCompletePorNome" instanciada na interface PacienteDAO
	 */
	@Override
	public List<String> autoCompletePorNome(String nome) {
		return em.createQuery("select p.nome from Paciente p where "
				+ "upper(p.nome) like upper(:n)",String.class)
				.setParameter("n","%"+nome+"%").getResultList();
	}

	/**
	 * Implementa��o da funcionalidade "listar" instanciada na interface PacienteDAO
	 */
	@Override
	public List<Paciente> listar() {
		return em.createQuery("from Paciente",Paciente.class)
				.getResultList();
	}

	/**
	 * Implementa��o da funcionalidade "buscarPorLogin" instanciada na interface PacienteDAO
	 */
	@Override
	public Paciente buscarPorLogin(String login, String senha) {
		
		return em.createQuery("from Paciente p where p.login = "
				+ ":l and p.senha = :s",Paciente.class)
				.setParameter("l", login)
				.setParameter("s", senha).getSingleResult();
	}

	

}
