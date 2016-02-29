package br.com.hdev.dao.impl;

import javax.persistence.EntityManager;

import br.com.hdev.dao.LogDAO;
import br.com.hdev.entity.Log;

/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * responsável por implementar as funcionalidades da interface LogDAO
 * 
 * @author HDEV
 *
 **/
public class LogDAOImpl extends DAOImpl<Log,Integer> implements LogDAO{

	/**
	 *  @param em -Parâmetro do EntityManager, responsável pela ligação com o banco
	 */
	public LogDAOImpl(EntityManager em) {
		super(em);

	}


}
