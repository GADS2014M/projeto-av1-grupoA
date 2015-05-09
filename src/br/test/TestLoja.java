package br.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.model.Carro;
import br.model.Loja;
import br.model.Moto;
import br.model.Veiculo;
import br.model.enums.Cambio;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Motorizacao;
import br.model.enums.Tipo;

public class TestLoja {

	@Test
	public void criaLoja() {

		// Cria um veiculo 01
		Veiculo veiculo = new Veiculo();
		veiculo.setChassi(Chassi.MODELOA);
		veiculo.setMontadora(Montadora.MODELOA);
		veiculo.setModelo(Modelo.MODELOA);
		veiculo.setTipo(Tipo.TIPOA);
		veiculo.setCor(Cor.AZUL);
		veiculo.setPreco(new BigDecimal(300.354));

		// Cria um veiculo
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setChassi(Chassi.MODELOA);
		veiculo2.setMontadora(Montadora.MODELOA);
		veiculo2.setModelo(Modelo.MODELOA);
		veiculo2.setTipo(Tipo.TIPOA);
		veiculo2.setCor(Cor.AZUL);
		veiculo2.setPreco(new BigDecimal(300.354));

		// Cria um veiculo
		Veiculo veiculo3 = new Veiculo();
		veiculo3.setChassi(Chassi.MODELOA);
		veiculo3.setMontadora(Montadora.MODELOA);
		veiculo3.setModelo(Modelo.MODELOA);
		veiculo3.setTipo(Tipo.TIPOA);
		veiculo3.setCor(Cor.AZUL);
		veiculo3.setPreco(new BigDecimal(300.354));
		// Cria um veiculo
		Veiculo veiculo4 = new Veiculo();
		veiculo4.setChassi(Chassi.MODELOA);
		veiculo4.setMontadora(Montadora.MODELOA);
		veiculo4.setModelo(Modelo.MODELOA);
		veiculo4.setTipo(Tipo.TIPOA);
		veiculo4.setCor(Cor.AZUL);
		veiculo4.setPreco(new BigDecimal(300.354));

		// cria uma moto 01
		Moto moto = new Moto();
		moto.setCapacidadeTanque(350);
		moto.setCilindrada(330);
		moto.setVeiculo(veiculo);

		// cria uma moto 02
		Moto moto2 = new Moto();
		moto2.setCapacidadeTanque(350);
		moto2.setCilindrada(330);
		moto2.setVeiculo(veiculo2);

		// cria um carro 01
		Carro carro = new Carro();
		carro.setCambio(Cambio.MODELOA);
		carro.setMotorizacao(Motorizacao.TIPOA);
		carro.setVeiculo(veiculo3);

		// cria um carro 02
		Carro carro2 = new Carro();
		carro2.setCambio(Cambio.MODELOA);
		carro2.setMotorizacao(Motorizacao.TIPOA);
		carro2.setVeiculo(veiculo4);

		// cria uma loja
		Loja loja = new Loja();
		loja.setNome("FordCar");
		loja.setEndereco("Infnet 001");
		// cria duas listas de moto
		ArrayList<Moto> motos = new ArrayList<Moto>();
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		// preenche lista com motos
		motos.add(moto);
		motos.add(moto2);
		
		// preenche lista com carros
		carros.add(carro);
		carros.add(carro2);
		
		// coloca tudo dentro da loja
		
		loja.setCarro(carros);
		loja.setMoto(motos);

		// abre conexão com banco
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test_projeto");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Insert veiculo
		em.persist(veiculo);
		em.persist(veiculo2);
		em.persist(veiculo3);
		em.persist(veiculo4);
		
		

		// insert moto
		em.persist(moto);
		em.persist(moto2);

		em.persist(carro);
		em.persist(carro2);
	
		// insert loja
		em.persist(loja);
		
		
		
		// fecha conexões
		em.getTransaction().commit();
		em.close();

	}
}
