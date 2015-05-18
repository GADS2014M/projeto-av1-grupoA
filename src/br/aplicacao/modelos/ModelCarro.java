package br.aplicacao.modelos;

import br.model.enums.Cambio;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Motorizacao;
import br.model.enums.Tipo;

public class ModelCarro extends ModelVeiculo {
	private Motorizacao motorizacao;
	private Cambio cambio;
	
	
	public ModelCarro(Chassi chassi, Montadora montadora, Modelo modelo,
			Tipo tipo, Cor cor, Motorizacao motorizacao, Cambio cambio) {
		super(chassi, montadora, modelo, tipo, cor);
		this.motorizacao = motorizacao;
		this.cambio = cambio;
	}


	public Motorizacao getMotorizacao() {
		return motorizacao;
	}


	public void setMotorizacao(Motorizacao motorizacao) {
		this.motorizacao = motorizacao;
	}


	public Cambio getCambio() {
		return cambio;
	}


	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	
	

}
