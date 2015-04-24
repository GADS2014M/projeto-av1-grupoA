package loja;

import java.util.ArrayList;
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
	private ArrayList<Carro> carros = new ArrayList<>();
	private ArrayList<Motocicleta> motocicletas = new ArrayList<>();
	
	
	
	
	/**
	 * adicionaCarro Adiciona objeto carro a lista
	 * primitiva de carros
	 * @param carro, objeto carro
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	public void adicionaCarro(Carro carro) {
		// TODO filtro de erros para p invalida
		this.carros.add(carro);
	}
	
	/**
	 * adicionaMoto Adiciona objeto carro a lista
	 * primitiva de Motocicleta
	 * @param moto, objeto Motocicleta
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	
	public void adicionaMoto(Motocicleta moto) {
		// TODO filtro de erros para p invalida
		this.motocicletas.add(moto);
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

	public ArrayList<Carro> getCarros() {
		return carros;
	}

	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}

	public ArrayList<Motocicleta> getMotocicletas() {
		return motocicletas;
	}

	public void setMotocicletas(ArrayList<Motocicleta> motocicletas) {
		this.motocicletas = motocicletas;
	}
	// fim get  e set
	
	
}
