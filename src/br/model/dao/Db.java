package br.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Db {

	private final String defaultDb = "projeto";
	private EntityManagerFactory emf;
	private EntityManager em;

	 
	 public Db(){
		 this.emf = Persistence.createEntityManagerFactory(this.defaultDb);
		 this.em = emf.createEntityManager();
	 }
		
	 

	// metodos
	public void commit() {
		this.em.getTransaction().commit();
	}
	
	private void close() {
		this.em.close();
	}
	
	// acesso

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public String getDefaultDb() {
		return defaultDb;
	}
	
	

	

}
