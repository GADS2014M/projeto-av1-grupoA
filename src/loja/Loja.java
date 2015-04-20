package loja;

import loja.veiculo.Carro;
import loja.veiculo.Motocicleta;

public class Loja {
	/**
	 * Class Loja Controle de estoque
	 * @author isvaldo,Yan
	 * @param endereco local da loja
	 * @param nome nome da loja
	 * @param carros Array primitiva de carros
	 * @param motocicleta Array primitiva de motocicleta
	 * */
	
	private String endereco;
	private String nome;
	private Carro[] carros;
	private Motocicleta[] motocicletas;
	private static final int CARROESTOQUE = 10;
	private static final int MOTOESTOQUE = 10;

	/**
	 * Construtor de Loja
	 * Inicia os valores default para arrays primitivas
	 * */
	Loja(){
		this.carros = new Carro[CARROESTOQUE];
	}

	/**
	 * adicionaCarro Adiciona objeto carro a lista
	 * primitiva de carros
	 * @param carro, objeto carro
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	
	public void adicionaCarro(Carro carro, int p) {
		// TODO filtro de erros para p invalida
		this.carros[p] = carro; 
	}
	
	
	/**
	 * adicionaMoto Adiciona objeto carro a lista
	 * primitiva de Motocicleta
	 * @param moto, objeto Motocicleta
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	
	public void adicionaMarro(Motocicleta moto, int p) {
		// TODO filtro de erros para p invalida
		this.motocicletas[p] = moto; 
	}
	
	
	
	// Get e Set
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Carro[] getCarros() {
		return carros;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}

	public Motocicleta[] getMotocicletas() {
		return motocicletas;
	}

	public void setMotocicletas(Motocicleta[] motocicletas) {
		this.motocicletas = motocicletas;
	}

	public static int getCarroestoque() {
		return CARROESTOQUE;
	}

	public static int getMotoestoque() {
		return MOTOESTOQUE;
	}
	// fim get  e set
	
	
}
