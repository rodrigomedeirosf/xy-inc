package br.com.xy.poi.model.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public abstract class CoreRepository {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	protected Session getSession(){
		return (Session) entityManager.getDelegate();
	}
	
}
