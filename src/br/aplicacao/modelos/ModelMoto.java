package br.aplicacao.modelos;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.model.Moto;
import br.model.dao.DAO;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;

public class ModelMoto extends ModelVeiculo{
	private Moto moto = new Moto();
	
	/**
	 *  Persistencia na amazon AWS
	 * @param chassi
	 * @param modelo
	 * @param montadora
	 * @param cor
	 * @param tipo
	 * @param preco
	 * @param capacidadeTanque
	 * @param cilindrada
	 */
	public ModelMoto(Chassi chassi, Modelo modelo, Montadora montadora, Cor cor,
			Tipo tipo, BigDecimal preco,int capacidadeTanque,float cilindrada) {
		super(chassi, modelo, montadora, cor, tipo, preco);
		this.moto.setCapacidadeTanque(capacidadeTanque);
		this.moto.setCilindrada(cilindrada);
		this.moto.setVeiculo(this.getVeiculo());
	}
	
	@Override
	public void saveAmazon() {
		DAO db = new DAO();
		// persiste veiculo no banco de dados
		EntityManager connection = db.getConnection();
		connection.persist(this.getVeiculo());
		// persiste Moto no banco
		connection.persist(this.moto);
		db.close();
	}

}
