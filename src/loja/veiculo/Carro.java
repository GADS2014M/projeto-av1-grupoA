package loja.veiculo;

import loja.Loja;
import loja.veiculo.types.Cambio;
import loja.veiculo.types.Chassi;
import loja.veiculo.types.Cor;
import loja.veiculo.types.Modelo;
import loja.veiculo.types.Montadora;
import loja.veiculo.types.Tipo;

public class Carro {
	
	/**
	 * Classe Carro Define um carro
	 *@author isvaldo,Yan
	 *@param chassi enumeração para chassi
	 *@param montadora enumeração para montadora
	 *@param modelo enumeração para modelo
	 *@param tipo enumeração para tipo
	 *@param cor enumeração para cor
	 *@param motorizacao float delimitando motorizacao
	 *@param cambio enumeração para cambio
	 *@param valor valor do carro
	 * */
	
	private Chassi chassi;
	private Montadora montadora;
	private Modelo modelo;
	private Tipo tipo;
	private Cor cor;
	private float motorizacao;
	private Cambio cambio;
	private float valor;
	
	         
	
	/**
	 * criaCarro cria um objeto carro
	 * @param chassi enumeração para chassi
	 * @param montadora enumeração para montadora
	 * @param modelo enumeração para modelo
	 * @param tipo enumeração para tipo
	 * @param cor enumeração para cor
	 * @param motorizacao float delimitando motorizacao
	 * @param cambio enumeração para cambio
	 * @param valor valor do carro
	 * @return objeto carro
	 */
	public static Carro criaCarro(Chassi chassi,       
			Montadora montadora, 
			Modelo modelo,       
			Tipo tipo,           
			Cor cor,             
			float motorizacao,   
			Cambio cambio,       
			float valor) {
		
		// TODO Colocar filtros
		Carro carro = new Carro();
		carro.setChassi(chassi);
		carro.setMontadora(montadora);
		carro.setModelo(modelo);
		carro.setTipo(tipo);
		carro.setCor(cor);
		carro.setMotorizacao(motorizacao);
		carro.setCambio(cambio);
		carro.setValor(valor);
		return carro;

	}
	
	// get e set
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
	public float getMotorizacao() {
		return motorizacao;
	}
	public void setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}
	public Cambio getCambio() {
		return cambio;
	}
	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	
	// fim get e set
	
}
