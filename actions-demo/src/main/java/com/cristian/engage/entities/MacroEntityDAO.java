package com.cristian.engage.entities;

// Generated May 23, 2014 7:42:18 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

/**
 * Home object for domain model class Macro.
 * 
 * @see com.cristian.engage.entities.Macro
 * @author Hibernate Tools
 */
public class MacroEntityDAO {

	private static final Logger log = Logger.getLogger(MacroEntityDAO.class);

	private static EntityManager entityManager = EntityManagerSource.INSTANCE.getEntityManager();

	public static void persist(MacroEntity transientInstance) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			try {
				List<ActionEntity> actions = transientInstance.getActions();
				if (actions != null && actions.size() > 0) {
					for (ActionEntity action : actions) {
						ActionEntityDAO.persist(action);
					}
				}
				entityManager.persist(transientInstance);
				tx.commit();
			} catch (Exception e) {
				log.error("add macro failed", e);
				tx.rollback();
			}
			finally {
				if(tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public static void remove(MacroEntity persistentInstance) {
		try {
			entityManager.remove(persistentInstance);
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public static MacroEntity merge(MacroEntity detachedInstance) {
		try {
			MacroEntity result = entityManager.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public static MacroEntity findById(Integer id) {
		try {
			MacroEntity instance = entityManager.find(MacroEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
