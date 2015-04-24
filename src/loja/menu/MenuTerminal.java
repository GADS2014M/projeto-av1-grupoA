package loja.menu;

import java.util.ArrayList;
import java.util.Scanner;

import loja.Loja;
import loja.veiculo.Carro;
import loja.veiculo.Motocicleta;
import loja.veiculo.types.Cambio;
import loja.veiculo.types.Chassi;
import loja.veiculo.types.Cor;
import loja.veiculo.types.Modelo;
import loja.veiculo.types.Montadora;
import loja.veiculo.types.Tipo;

public class MenuTerminal implements Menu{
	public final static int  SPACES=10;
	public final static int SEGUNDO=1000;
	private Loja loja = new Loja();
	private Scanner sc = new Scanner(System.in);


	/*Cria um menu para uma loja*/
	public MenuTerminal(Loja loja) {
		this.setLoja(loja);
		this.display();
	}


	@Override
	public void display() {

		//Listando todas opções do programa
		System.out.println("1) Adicionar carro\n"
				+ "2) Adicionar moto\n"
				+ "3) Pesquisar carro\n"
				+ "4) Pesquisar moto\n"
				+ "5) Buscar carro pelo chassi\n"
				+ "6) Buscar moto pelo chassi\n"
				+ "7) Listar estoque de carros\n"
				+ "8) Listar estoque de motos\n"
				+ "9) Sair");
		
		System.out.println("Escolha uma opção válida:");
		int escolha = sc.nextInt();
		switch(escolha){

		case 1:
			this.adicionaCarroByTerminal();
			break;
			
		case 2:
			this.adicionaMotoByTerminal();
			break;
			
		case 3:
			this.pesquisaCarroByAtributes();
			break;
			
		case 4:
			this.pesquisaMotoByAtributes();
			break;
			
		case 5:
			this.buscaCarroByChassi();
			break;
			
		case 6:
			this.buscaMotoByChassi();
			break;
			
		case 7:
			this.listarEstoquedeCarros();
			break;
			
		case 8:
			this.listarEstoquedeMotos();
			break;


		case 9:
			System.out.println("Programa sendo fechado");
			this.sleep(SEGUNDO);
			System.exit(0);
			break;
		default:
			System.out.println("Opção invalida");
			this.sleep(SEGUNDO);
			//Apaga tudo, mostra display
			refresh();
			display();
		}
		//Apaga tudo, mostra display
		refresh();
		display();





	}

	@Override
	public void refresh() {
		/**
		 * usa Cls para windows e clear em unix (:
		 * */
		 try
		    {
		        final String os = System.getProperty("os.name");

		        if (os.contains("Windows"))
		        {
		            Runtime.getRuntime().exec("cls");
		        }
		        else
		        {
		            Runtime.getRuntime().exec("clear");
		        }
		    }
		    catch (final Exception e)
		    {
		    	//TODO colocar filtro, exception
		        System.out.println("So lamento !");
		    }

	}

	/**
	 * sleep
	 * causa uma espera no codigo
	 */
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}



	public void adicionaCarroByTerminal(){
		Carro carro = getCarroValues();
		this.getLoja().adicionaCarro(carro);
	}


	public void adicionaMotoByTerminal(){
		Motocicleta moto = getMotoValues();
		this.getLoja().adicionaMoto(moto);
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
	private void buscaCarroByChassi() {
		Chassi chassi = getChassi();
		ArrayList<Carro> resultadoBuscaCarro = new ArrayList<>();
		for (Carro carro: this.getLoja().getCarros()){
			if(carro.getChassi() == chassi){
				resultadoBuscaCarro.add(carro);
			}
		}

		for(Carro carro : resultadoBuscaCarro)
			System.out.println(carro);
	}

	private void buscaMotoByChassi() {
		Chassi chassi = getChassi();
		ArrayList<Motocicleta> resultadoBuscaMoto = new ArrayList<>();
		for (Motocicleta moto: this.getLoja().getMotocicletas()){
			if(moto.getChassi() == chassi){
				resultadoBuscaMoto.add(moto);
			}
		}

		for(Motocicleta moto: resultadoBuscaMoto)
			System.out.println(moto);
	}




	/**
	 * pesquisaCarroByTerminal, Pesquisa um carro usando todos os atributos
	 * @return ArrayList de carro com todos os resultados
	 * */
	private void pesquisaCarroByAtributes() {
		ArrayList<Carro> resultadoPesquisa = new ArrayList<>();
		Carro carroTeste =  getCarroValues();
		for (Carro carro : this.getLoja().getCarros()) {
			if (carro.equals(carroTeste))
				resultadoPesquisa.add(carro);
		}
		for(Carro carro : resultadoPesquisa)
			System.out.println(carro);
	}

	/**
	 * pesquisaMotoByTerminal, Pesquisa uma moto usando todos os atributos
	 * @return ArrayList de moto com todos os resultados
	 * */
	private void pesquisaMotoByAtributes() {
		ArrayList<Motocicleta> resultadoPesquisa = new ArrayList<>();
		Motocicleta motoTeste =  getMotoValues();
		for (Motocicleta moto : this.getLoja().getMotocicletas()) {
			if (moto.equals(motoTeste))
				resultadoPesquisa.add(moto);
		}
		for (Motocicleta moto : resultadoPesquisa)
			System.out.println(moto);
	}


	private void listarEstoquedeCarros() {
		for (Carro carro: this.getLoja().getCarros())
			System.out.println(carro);
	}

	private void listarEstoquedeMotos() {
		for (Motocicleta moto: this.getLoja().getMotocicletas())
			System.out.println(moto);

	}

	/**
	 * getCarroValues, coleta todos itens de carro
	 * @return Objeto carro
	 */
	private Carro getCarroValues() {
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
		return carro;
	}

	/**
	 * getMotoValues, coleta todos itens de moto
	 * @return objeto moto
	 */
	private Motocicleta getMotoValues() {
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
		return moto;
	}


	// get e set
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}


	// fim get e set





}
