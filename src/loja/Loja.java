package loja;

import java.util.ArrayList;
import java.util.Scanner;

import loja.veiculo.Carro;
import loja.veiculo.Motocicleta;
import loja.veiculo.types.Cambio;
import loja.veiculo.types.Chassi;
import loja.veiculo.types.Cor;
import loja.veiculo.types.Modelo;
import loja.veiculo.types.Montadora;
import loja.veiculo.types.Tipo;

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
	private Scanner sc = new Scanner(System.in);

	/**
	 * adicionaCarro Adiciona objeto carro a lista
	 * primitiva de carros
	 * @param carro, objeto carro
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	private void adicionaCarro(Carro carro) {
		// TODO filtro de erros para p invalida
		this.carros.add(carro);
	}
	
	/**
	 * adicionaMoto Adiciona objeto carro a lista
	 * primitiva de Motocicleta
	 * @param moto, objeto Motocicleta
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	
	private void adicionaMoto(Motocicleta moto) {
		// TODO filtro de erros para p invalida
		this.motocicletas.add(moto);
	}
	
	public void adicionaCarroByTerminal(){
		Chassi chassi = getChassi();
		Montadora montadora = getMontadora();
		Modelo modelo = getModelo();
		Tipo tipo = getTipo();
		Cor cor = getCor();
		System.out.println("Qual motorização?");
		float motorizacao = this.sc.nextFloat();
		Cambio cambio = getCambio();
		System.out.println("Qual valor do carro?");
		float valor = this.sc.nextFloat();
		Carro carro =  Carro.criaCarro(chassi, montadora, modelo, tipo, cor, motorizacao, cambio, valor);
		adicionaCarro(carro);
	}
	
	public void adicionaMotoByTerminal(){
		Chassi chassi = getChassi();
		Montadora montadora = getMontadora();
		Modelo modelo = getModelo();
		Tipo tipo = getTipo();
		Cor cor = getCor();
		System.out.println("Qual a capacidade do tanque?");
		byte capacidadeDoTanque  = (byte) this.sc.nextInt();
		System.out.println("Qual a cilindadra?");
		int cilindrada = this.sc.nextInt();
		System.out.println("Qual valor da moto?");
		float valor = this.sc.nextFloat();
		Motocicleta moto = Motocicleta.criaMoto(chassi, montadora, modelo, tipo, cor, cilindrada, capacidadeDoTanque, valor);
		adicionaMoto(moto);
	}

	/**
	 * getChassi
	 * Mostra uma lista valida de chassi
	 * @return Objeto chassi
	 */
	private Chassi getChassi() {
		//@TODO colocar filtros
		System.out.println("Escolha um chassi disponivel");
		this.mostraOpcao(Chassi.class);
		System.out.println("Informe uma ID(numeral)");
		return Chassi.valueOf(getGenericsEnumByCode(Chassi.class,this.sc.nextInt()));
		
	}
	
	/**
	 * getMontadora
	 * Mostra uma lista valida de Montadora
	 * @return Objeto Montadora
	 */
	private Montadora getMontadora() {
		//@TODO colocar filtros
		System.out.println("Escolha uma Montadora disponivel");
		this.mostraOpcao(Montadora.class);
		System.out.println("Informe uma ID(numeral)");
		return Montadora.valueOf(getGenericsEnumByCode(Montadora.class,this.sc.nextInt()));
		
	}
	
	/**
	 * getModelo
	 * Mostra uma lista valida de Modelo
	 * @return Objeto Modelo
	 */
	private Modelo getModelo() {
		//@TODO colocar filtros
		System.out.println("Escolha um Modelo disponivel");
		this.mostraOpcao(Modelo.class);
		System.out.println("Informe uma ID(numeral)");
		return Modelo.valueOf(getGenericsEnumByCode(Modelo.class,this.sc.nextInt()));
	}
	
	/**
	 * getTipo
	 * Mostra uma lista valida de Tipo
	 * @return Objeto Tipo
	 */
	private Tipo getTipo() {
		//@TODO colocar filtros
		System.out.println("Escolha um Tipo disponivel");
		this.mostraOpcao(Tipo.class);
		System.out.println("Informe uma ID(numeral)");
		return Tipo.valueOf(getGenericsEnumByCode(Tipo.class,this.sc.nextInt()));
	}
	
	/**
	 * getCor
	 * Mostra uma lista valida de Cor
	 * @return Objeto Cor
	 */
	private Cor getCor() {
		//@TODO colocar filtros
		System.out.println("Escolha uma Cor disponivel");
		this.mostraOpcao(Cor.class);
		System.out.println("Informe uma ID(numeral)");
		return Cor.valueOf(getGenericsEnumByCode(Cor.class,this.sc.nextInt()));
	}
	
	/**
	 * getCambio
	 * Mostra uma lista valida de Cambio
	 * @return Objeto Cambio
	 */
	private Cambio getCambio() {
		//@TODO colocar filtros
		System.out.println("Escolha um Cambio disponivel");
		this.mostraOpcao(Cambio.class);
		System.out.println("Informe uma ID(numeral)");
		return Cambio.valueOf(getGenericsEnumByCode(Cambio.class,this.sc.nextInt()));
	}
	
	
	public static void main(String[] args) {
		//new Loja().adicionaCarroByTerminal();
		//new Loja().adicionaMotoByTerminal();
	}

	/**
	 * mostraOpcao mostra opções de um enum de forma generica
	 * @param enumClass classe de um enum
	 */
	private <T extends Enum<T>> void mostraOpcao(Class<T> enumClass) {
	    for (Enum<T> item : enumClass.getEnumConstants()) {
	    	// Mostra valor -> representacao
	        System.out.println(item.ordinal()+"->"+item.toString());
	    }
	}

	
	/**
	 * getGenericsEnumByCode retorna um enum generico pelo codigo
	 * @param enumClass classe de um enum
	 * @param code valor que apontado pelo enum
	 */
	private  <T extends Enum<T>> String getGenericsEnumByCode(Class<T> enumClass,int code) {
	    for (Enum<T> item : enumClass.getEnumConstants()) {
	    	if (item.ordinal() ==code){
	    		return item.toString();
	    	}
	    }
	    //@TODO adicionar filtros
	    System.out.println("Valor não encotnrado");
	    return "Erro";
	}
	
	/**/
	private ArrayList<Carro> buscaCarroByChassi() {
		Chassi chassi = getChassi();
		ArrayList<Carro> resultadoBuscaCarro = new ArrayList<>();
		for (Carro carro: this.carros){
			if(carro.getChassi() == chassi){
				resultadoBuscaCarro.add(carro);
			}
		}
		
		return resultadoBuscaCarro;
	}
	
	private ArrayList<Motocicleta> buscaMotoByChassi() {
		Chassi chassi = getChassi();
		ArrayList<Motocicleta> resultadoBuscaMoto = new ArrayList<>();
		for (Motocicleta moto: this.motocicletas){
			if(moto.getChassi() == chassi){
				resultadoBuscaMoto.add(moto);
			}
		}
		
		return resultadoBuscaMoto;
	}
	
	
	/**/
	private void pesquisaCarro(Chassi chassi,
			Montadora montadora,
			Modelo modelo,
			Tipo tipo,
			Cor cor,             
			float motorizacao,   
			Cambio cambio,       
			float valor) {
		
		
		
		

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
