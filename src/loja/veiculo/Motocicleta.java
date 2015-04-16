package loja.veiculo;

import loja.veiculo.types.Chassi;
import loja.veiculo.types.Cor;
import loja.veiculo.types.Modelo;
import loja.veiculo.types.Montadora;
import loja.veiculo.types.Tipo;

public class Motocicleta {
	
	
	/**
	 * Classe Carro Define um carro
	 *@author isvaldo,Yan
	 *@param chassi enumeração para chassi
	 *@param montadora enumeração para montadora
	 *@param modelo enumeração para modelo
	 *@param tipo enumeração para tipo
	 *@param cor enumeração para cor
	 *@param cilindrada inteiro para cilindrada
	 *@param cambio enumeração para cambio
	 *@param capacidadeDoTanque valor 0-127L para tanque
	 *@param valor preço da moto
	 * */
	
	private Chassi chassi;
	private Montadora montadora;
	private Modelo modelo;
	private Tipo tipo;
	private Cor cor;
	private int cilindrada;
	private byte capacidadeDoTanque;
	private float valor;
}
