package br.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

	private final String defaultDb = "test_projeto";
	private EntityManagerFactory emf;
	private EntityManager em;
	 
	 
	// cria uma nova conexão
	 public EntityManager getConnection(){
		 this.emf = Persistence.createEntityManagerFactory(this.defaultDb);
		 this.em = emf.createEntityManager();
		 this.em.getTransaction().begin();
		 return this.em;
	 }
	// metodos
	public void commit() {
		this.em.getTransaction().commit();
	}
	
	public  void close() {
		this.em.getTransaction().commit();
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
