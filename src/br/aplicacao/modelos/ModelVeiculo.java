package br.aplicacao.modelos;

import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;


public abstract class ModelVeiculo {
	private Chassi chassi;
	private Montadora montadora;
	private Modelo modelo;
	private Tipo tipo;
	private Cor cor;
	
	public ModelVeiculo(Chassi chassi, Montadora montadora, Modelo modelo,
			Tipo tipo, Cor cor) {
		super();
		this.chassi = chassi;
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cor = cor;
	}
	
	public Chassi getChassi() {
		return chassi;
	}
	public void setChassi(Chassi chassi) {
		this.chassi = chassi;
	}
	public Montadora getMontadora() {
		return montadora;
	}
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
}
