package br.test.model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.model.Veiculo;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;

public class TestVeiculosPersist {

	@Test
	public void CriarVeiculo() {
		Veiculo veiculo = new Veiculo();

		veiculo.setChassi(Chassi.TIPOA);
		veiculo.setMontadora(Montadora.HONDA);
		veiculo.setModelo(Modelo.MODELOA);
		veiculo.setTipo(Tipo.SEDAN);
		veiculo.setCor(Cor.AZUL);
		veiculo.setPreco(new BigDecimal(500));

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test_projeto");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		em.close();
	}
}