package br.aplicacao.modelos;

import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;

public class ModelMoto extends ModelVeiculo{
	private float cilindrada;
	private int capacidadeTanque;
	
	public ModelMoto(Chassi chassi, Montadora montadora, Modelo modelo,
			Tipo tipo, Cor cor, float cilindrada,int capacidadeTanque) {
		super(chassi, montadora, modelo, tipo, cor);
		this.cilindrada = cilindrada;
		this.capacidadeTanque = capacidadeTanque;
	}

	public float getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(float cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	
	
	
}
