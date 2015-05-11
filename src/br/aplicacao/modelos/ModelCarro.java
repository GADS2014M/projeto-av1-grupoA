package br.aplicacao.modelos;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.model.Carro;
import br.model.dao.DAO;
import br.model.enums.Cambio;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Motorizacao;
import br.model.enums.Tipo;

public class ModelCarro extends ModelVeiculo {
	private Carro carro= new Carro();

	/**
	 * Persiste Carro na Amazon Aws
	 * 
	 * @param chassi
	 * @param modelo
	 * @param montadora
	 * @param cor
	 * @param tipo
	 * @param preco
	 * @param cambio
	 * @param motorizacao
	 */
	public ModelCarro(Chassi chassi, Modelo modelo, Montadora montadora, Cor cor,
			Tipo tipo, BigDecimal preco, Cambio cambio, Motorizacao motorizacao) {

		super(chassi, modelo, montadora, cor, tipo, preco);
		carro.setCambio(cambio);
		carro.setMotorizacao(motorizacao);
		carro.setVeiculo(this.getVeiculo());
	}


	@Override
	public void saveAmazon() {
		DAO db = new DAO();
		// persiste veiculo no banco de dados
		EntityManager connection = db.getConnection();
		connection.persist(this.getVeiculo());
		// persismte Carro no banco de dados
		connection.persist(this.getCarro());
		db.close();

	}
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
