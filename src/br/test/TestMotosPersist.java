package br.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.model.Moto;
import br.model.Veiculo;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;

public class TestMotosPersist {

	@Test
	public void criaMotos() {
		// Cria um veiculo
		Veiculo veiculo = new Veiculo();
		veiculo.setChassi(Chassi.MODELOA);
		veiculo.setMontadora(Montadora.MODELOA);
		veiculo.setModelo(Modelo.MODELOA);
		veiculo.setTipo(Tipo.TIPOA);
		veiculo.setCor(Cor.AZUL);
		veiculo.setPreco(new BigDecimal(300.354));

		// cria uma moto
		Moto moto = new Moto();
		moto.setCapacidadeTanque(350);
		moto.setCilindrada(330);
		moto.setVeiculo(veiculo);

		// abre conexão com banco
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test_projeto");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Insert veiculo
		em.persist(veiculo);

		// insert moto
		em.persist(moto);

		// fecha conexões
		em.getTransaction().commit();
		em.close();

	}
}
