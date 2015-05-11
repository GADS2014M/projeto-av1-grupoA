package br.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.model.Loja;

public class TestLoja {

	@Test
	public void criaLoja() {

		// cria uma loja
		Loja loja = new Loja();
		loja.setNome("FordCar");
		loja.setEndereco("Infnet 001");
		
		
		// abre conexão com banco
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test_projeto");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// insert loja
		em.persist(loja);

		// fecha conexões
		em.getTransaction().commit();
		em.close();

	}
}
