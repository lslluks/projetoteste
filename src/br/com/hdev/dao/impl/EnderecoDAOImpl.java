package br.com.hdev.dao.impl;

import javax.persistence.EntityManager;

import br.com.hdev.dao.EnderecoDAO;
import br.com.hdev.entity.Endereco;

/**
 * Classe que herda de uma interface(DAO) implementada(DAOImpl) com CRUD
 * responsável por implementar as funcionalidades da interface EnderecoDAO
 * 
 * @author HDEV
 *
 **/
public class EnderecoDAOImpl extends DAOImpl<Endereco,Integer> implements EnderecoDAO{

/**
 *  @param em -Parâmetro do EntityManager, responsável pela ligação com o banco
 */
	public EnderecoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
