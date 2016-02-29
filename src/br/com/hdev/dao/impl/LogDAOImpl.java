package br.com.hdev.dao.impl;

import javax.persistence.EntityManager;

import br.com.hdev.dao.LogDAO;
import br.com.hdev.entity.Log;

/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * respons�vel por implementar as funcionalidades da interface LogDAO
 * 
 * @author HDEV
 *
 **/
public class LogDAOImpl extends DAOImpl<Log,Integer> implements LogDAO{

	/**
	 *  @param em -Par�metro do EntityManager, respons�vel pela liga��o com o banco
	 */
	public LogDAOImpl(EntityManager em) {
		super(em);

	}


}
