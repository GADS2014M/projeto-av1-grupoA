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

}
