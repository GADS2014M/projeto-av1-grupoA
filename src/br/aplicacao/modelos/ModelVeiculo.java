package br.aplicacao.modelos;

import java.math.BigDecimal;

import br.model.Veiculo;
import br.model.dao.DAO;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;


public abstract class ModelVeiculo extends DAO{
	private Veiculo veiculo = new Veiculo();


	ModelVeiculo(Chassi chassi,Modelo modelo,
			Montadora montadora,
			Cor cor,
			Tipo tipo,
			BigDecimal preco){
		this.veiculo.setChassi(chassi);
		this.veiculo.setModelo(modelo);
		this.veiculo.setMontadora(montadora);
		this.veiculo.setCor(cor);
		this.veiculo.setTipo(tipo);
		this.veiculo.setPreco(preco);
	}
	public void saveAmazon(){
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
