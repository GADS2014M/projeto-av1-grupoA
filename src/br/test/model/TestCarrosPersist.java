package br.test.model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.model.Carro;
import br.model.Veiculo;
import br.model.enums.Cambio;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Motorizacao;
import br.model.enums.Tipo;

public class TestCarrosPersist {

	@Test
	public void criaObjetoCarroComVeiculo() {

		// Cria um veiculo
		Veiculo veiculo = new Veiculo();
		veiculo.setChassi(Chassi.TIPOA);
		veiculo.setMontadora(Montadora.FIAT);
		veiculo.setModelo(Modelo.MODELOA);
		veiculo.setTipo(Tipo.COUPE);
		veiculo.setCor(Cor.AZUL);
		veiculo.setPreco(new BigDecimal(500));

		// cria um carro
		Carro carro = new Carro();
		carro.setCambio(Cambio.AUTOMATICO);
		carro.setMotorizacao(Motorizacao.TIPOA);
		carro.setVeiculo(veiculo);

		// abre conexão com banco
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test_projeto");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Insert veiculo
		em.persist(veiculo);

		// insert carro
		em.persist(carro);

		// fecha conexões
		em.getTransaction().commit();
		em.close();
	}
}
