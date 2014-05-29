package com.cristian.engage.entities;

// Generated May 23, 2014 7:42:18 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.EntityManager;


import org.jboss.logging.Logger;

/**
 * Home object for domain model class Action.
 * @see com.cristian.engage.entities.Action
 * @author Hibernate Tools
 */
public class ActionEntityDAO {
	
	private static final Logger log = Logger.getLogger(ActionEntityDAO.class);
	
	private static EntityManager entityManager = EntityManagerSource.INSTANCE.getEntityManager();

	public static void persist(ActionEntity transientInstance) {
		try {
			entityManager.persist(transientInstance);
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ActionEntity persistentInstance) {
		try {
			entityManager.remove(persistentInstance);
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ActionEntity merge(ActionEntity detachedInstance) {
		try {
			ActionEntity result = entityManager.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ActionEntity findById(Integer id) {
		try {
			ActionEntity instance = entityManager.find(ActionEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
