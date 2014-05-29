package com.cristian.engage.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 * Singleton used to retrieve an EntityManager instance
 * 
 * @author cristian.cical
 *
 */
public enum EntityManagerSource {
	INSTANCE;
	
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if(entityManager == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public void closeEntityManager() {
		entityManager.close();
		entityManager = null;
	}
	
}
