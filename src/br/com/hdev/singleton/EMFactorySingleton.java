package br.com.hdev.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * EntityManagerFactorySingleton classe para gerenciar a única instância de
 * EntityManagerFactory
 * 
 * @author HDEV
 */
public class EMFactorySingleton {

	private static EntityManager em;

	private EMFactorySingleton() {
	}

	public static EntityManager getInstance() {
		if (em == null) {
			em = Persistence
					.createEntityManagerFactory("CLIENTE_ORACLE")
					.createEntityManager();
		}
		return em;
	}
}
