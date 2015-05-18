package br.aplicacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import br.aplicacao.modelos.ModelCarro;
import br.aplicacao.modelos.ModelLoja;
import br.aplicacao.modelos.ModelMoto;
import br.model.Carro;
import br.model.Loja;
import br.model.Moto;
import br.model.dao.DAO;
import br.model.enums.Cambio;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Motorizacao;
import br.model.enums.Tipo;

public class Menu {
	private ModelLoja modelLoja = new ModelLoja();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Menu menu = new Menu();
		// escolhe uma das lojas para usar
		menu.escolheLoja();
		// Mostra Qual foi a loja selecionada
		System.out.println("Bem vindo na loja "
				+ menu.getModelLoja().getLoja().getNome());
		System.out.println("Atualmente em "
				+ menu.getModelLoja().getLoja().getEndereco());

		// mostra lista com opções principais
		menu.displayPrincipal();

	}

	/**
	 * Escolhe uma loja para trabalhar
	 */
	private void escolheLoja() {

		System.out.println("1) Nova Loja\n" + "2)Selecionar uma existente");
		int escolha = getNumeroFromTerminal();
		switch (escolha) {
		case 1:
			System.out.println("Selecione Nome:");
			String nome = getStringTerminal();
			System.out.println("Selecione Endereço:");
			String endereco = getStringTerminal();
			this.getModelLoja().criaLoja(nome, endereco);
			break;

		case 2:
			// escolha uma existente
			Loja loja = this.displayLojas();
			this.getModelLoja().setLoja(loja);
			break;

		default:
			System.err.println("Opção invalida");

		}
	}

	/**
	 * Metodo Base de coleta de String, usada em Junit
	 */
	private String getStringTerminal() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		return line;
	}

	/**
	 * Retorna um numero inteiro do terminal
	 */
	private static int getNumeroFromTerminal() {
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		return numero;
	}

	public Loja displayLojas() {

		List<Loja> lojas = GetAllLojas();
		System.out.println("Escolha o ID de uma loja");
		for (Loja loja : lojas) {
			System.out.println(loja.getId() + " -> "
					+ loja.getNome().toUpperCase());
		}

		// seleciona uma loja, quando valida retorna id
		try {
			Scanner sc = new Scanner(System.in);
			int escolha = sc.nextInt();
			for (Loja loja : lojas) {
				if (loja.getId() == escolha) {
					return loja;
				}

			}

		} catch (InputMismatchException e) {
			System.out.println("Tipo invalido, ou inexistente,tente novamente");
			return displayLojas();
		}
		return displayLojas();
	}

	/**
	 * Retorna todas as lojas em uma lista
	 * 
	 * @return Lojas
	 */
	private List<Loja> GetAllLojas() {
		DAO db = new DAO();
		// Query Estilo Hibernate, nome da tabela = nome da classe
		Query createQuery = db.getConnection().createQuery("from Loja");
		// cria uma lista com todas as lojas criadas
		List<Loja> lojas = createQuery.getResultList();
		// fecha conexão
		db.close();
		return lojas;
	}

	public void displayPrincipal() {

		// Listando todas opções do programa
		System.out.println("1) Adicionar carro\n" + "2) Adicionar moto\n"
				+ "3) Pesquisar carro\n" + "4) Pesquisar moto\n"
				+ "5) Buscar carro pelo chassi\n"
				+ "6) Buscar moto pelo chassi\n"
				+ "7) Listar estoque de carros\n"
				+ "8) Listar estoque de motos\n" + "9) Sair");

		System.out.println("Escolha uma opção válida:");
		Scanner sc = new Scanner(System.in);
		int escolha = sc.nextInt();
		switch (escolha) {

		case 1:
			this.adicionaCarroByTerminal();
			break;

		case 2:
			this.adicionaMotoByTerminal();
			break;

		case 3:
			try {
				this.pesquisaCarroByAtributes();
			} catch (RuntimeException e) {
				System.out.println("Não foi possivel pesquisar esse item\n" + e);
			}
			break;

		case 4:
			try {
				this.pesquisaMotoByAtributes();
			} catch (RuntimeException e) {
				System.out.println("Não foi possivel pesquisar esse item\n" + e);
			}
			break;

		case 5:
			// TODO Refactor need !
			this.getModelLoja().atualizaEstoque();
			Chassi chassi = getChassi();
			for (Carro carro : this.getModelLoja().getCarros())
				if (carro.getVeiculo().getChassi() == chassi)
					System.out.println(carro);

			break;

		case 6:
			// TODO Refactor need !
			this.getModelLoja().atualizaEstoque();
			Chassi chMoto = getChassi();
			for (Moto moto : this.getModelLoja().getMotos())
				if (moto.getVeiculo().getChassi() == chMoto)
					System.out.println(moto);

			break;

		case 7:
			// lista carros
			this.getModelLoja().atualizaEstoque();
			for (Carro carro : this.getModelLoja().getCarros()) {
				System.out.println(carro);
			}
			break;

		case 8:
			// lista motos
			this.getModelLoja().atualizaEstoque();
			for (Moto moto : this.getModelLoja().getMotos()) {
				System.out.println(moto);
			}
			break;

		case 9:
			System.out.println("Programa sendo fechado");
			System.exit(0);
			break;
		default:
			System.out.println("Opção invalida");
			// Apaga tudo, mostra display
			displayPrincipal();
		}
		// Apaga tudo, mostra display
		displayPrincipal();

	}

	private void pesquisaMotoByAtributes() {
		System.out.println("Vamos Pesquisar um carro");
		this.getModelLoja().atualizaEstoque();
		List<Moto> motos = this.getModelLoja().getMotos();

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Chassi chassi = getChassi();
			ArrayList<Moto> tempCarros = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getVeiculo().getChassi() == chassi)
					tempCarros.add(moto);

			}
			motos = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Montadora montadora = getMontadora();
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getVeiculo().getMontadora() == montadora)
					tempMotos.add(moto);

			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Modelo modelo = getModelo();
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getVeiculo().getModelo() == modelo)
					tempMotos.add(moto);

			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Tipo tipo = getTipo();
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getVeiculo().getTipo() == tipo)
					tempMotos.add(moto);

			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Cor cor = getCor();
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getVeiculo().getCor() == cor)
					tempMotos.add(moto);

			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			System.out.println("Qual a capacidade do tanque?");
			int capacidadeDoTanque = this.sc.nextInt();
			if (capacidadeDoTanque == 0)
				throw new RuntimeException("Valor Scape");
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getCapacidadeTanque() == capacidadeDoTanque)
					tempMotos.add(moto);

			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			System.out.println("Qual a cilindadra?");
			int cilindrada = this.sc.nextInt();
			if (cilindrada == 0)
				throw new RuntimeException("Valor Scape");
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getCilindrada() == cilindrada)
					tempMotos.add(moto);

			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			System.out.println("Qual valor do carro?");
			BigDecimal valor = new BigDecimal(this.sc.nextFloat());
			if (valor.intValue() == 0)
				throw new RuntimeException("0 é valor de scape");
			ArrayList<Moto> tempMotos = new ArrayList<Moto>();
			for (Moto moto : motos) {
				if (moto.getVeiculo().getPreco() == valor)
					tempMotos.add(moto);
			}
			motos = tempMotos;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (motos.size() == 0)
			throw new RuntimeException("Não há Resultados");

		for (Moto moto : motos) {
			System.out.println(moto);
		}

	}

	private void pesquisaCarroByAtributes() {

		System.out.println("Vamos Pesquisar um carro");
		this.getModelLoja().atualizaEstoque();
		List<Carro> carros = this.getModelLoja().getCarros();

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Chassi chassi = getChassi();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getVeiculo().getChassi() == chassi)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Montadora montadora = getMontadora();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getVeiculo().getMontadora() == montadora)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Modelo modelo = getModelo();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getVeiculo().getModelo() == modelo)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Tipo tipo = getTipo();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getVeiculo().getTipo() == tipo)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Cor cor = getCor();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getVeiculo().getCor() == cor)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Motorizacao motorizacao = getMotorizacao();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getMotorizacao() == motorizacao)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			Cambio cambio = getCambio();
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getCambio() == cambio)
					tempCarros.add(carro);

			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		try {
			System.out.println("Qual valor do carro?");
			BigDecimal valor = new BigDecimal(this.sc.nextFloat());
			if (valor.intValue() == 0)
				throw new RuntimeException("0 é valor de scape");
			ArrayList<Carro> tempCarros = new ArrayList<Carro>();
			for (Carro carro : carros) {
				if (carro.getVeiculo().getPreco() == valor)
					tempCarros.add(carro);
			}
			carros = tempCarros;
		} catch (Exception e) {
			System.out.println("Filtro ignorado");

		}

		if (carros.size() == 0)
			throw new RuntimeException("Não há Resultados");

		for (Carro carro : carros) {
			System.out.println(carro);
		}

	}

	private void adicionaMotoByTerminal() {
		Chassi chassi = getChassi();
		Montadora montadora = getMontadora();
		Modelo modelo = getModelo();
		Tipo tipo = getTipo();
		Cor cor = getCor();
		System.out.println("Qual a capacidade do tanque?");
		int capacidadeDoTanque = this.sc.nextInt();
		System.out.println("Qual a cilindadra?");
		int cilindrada = this.sc.nextInt();
		System.out.println("Qual valor da moto?");
		BigDecimal valor = new BigDecimal(this.sc.nextFloat());
		ModelMoto modelMoto = new ModelMoto(chassi, modelo, montadora, cor,
				tipo, valor, cilindrada, capacidadeDoTanque);
		modelMoto.saveAmazon();
		// @TODO melhorar isso
		this.getModelLoja().atualizaEstoque();

	}

	private void adicionaCarroByTerminal() {
		Chassi chassi = getChassi();
		Montadora montadora = getMontadora();
		Modelo modelo = getModelo();
		Tipo tipo = getTipo();
		Cor cor = getCor();
		System.out.println("Qual motorização?");
		Motorizacao motorizacao = getMotorizacao();
		Cambio cambio = getCambio();
		System.out.println("Qual valor do carro?");
		BigDecimal valor = new BigDecimal(this.sc.nextFloat());
		ModelCarro carro = new ModelCarro(chassi, modelo, montadora, cor, tipo,
				valor, cambio, motorizacao);
		carro.saveAmazon();
		// @TODO melhorar isso
		this.getModelLoja().atualizaEstoque();
	}

	/**
	 * getChassi Mostra uma lista valida de chassi
	 * 
	 * @return Objeto chassi
	 */
	public Chassi getChassi() {
		// @TODO colocar filtros
		System.out.println("Escolha um chassi disponivel");
		this.mostraOpcao(Chassi.class);
		System.out.println("Informe uma ID(numeral)");
		return Chassi.valueOf(getGenericsEnumByCode(Chassi.class,
				this.sc.nextInt()));

	}

	/**
	 * getMontadora Mostra uma lista valida de Montadora
	 * 
	 * @return Objeto Montadora
	 */
	private Montadora getMontadora() {
		// @TODO colocar filtros
		System.out.println("Escolha uma Montadora disponivel");
		this.mostraOpcao(Montadora.class);
		System.out.println("Informe uma ID(numeral)");
		return Montadora.valueOf(getGenericsEnumByCode(Montadora.class,
				this.sc.nextInt()));

	}

	/**
	 * getModelo Mostra uma lista valida de Modelo
	 * 
	 * @return Objeto Modelo
	 */
	private Modelo getModelo() {
		// @TODO colocar filtros
		System.out.println("Escolha um Modelo disponivel");
		this.mostraOpcao(Modelo.class);
		System.out.println("Informe uma ID(numeral)");
		return Modelo.valueOf(getGenericsEnumByCode(Modelo.class,
				this.sc.nextInt()));
	}

	/**
	 * getmotorizacao Mostra uma lista valida de motorizacao
	 * 
	 * @return Objeto motorizacao
	 */
	private Motorizacao getMotorizacao() {
		// @TODO colocar filtros
		System.out.println("Escolha uma motorizacao disponivel");
		this.mostraOpcao(Motorizacao.class);
		System.out.println("Informe uma ID(numeral)");
		return Motorizacao.valueOf(getGenericsEnumByCode(Motorizacao.class,
				this.sc.nextInt()));
	}

	/**
	 * getTipo Mostra uma lista valida de Tipo
	 * 
	 * @return Objeto Tipo
	 */
	private Tipo getTipo() {
		// @TODO colocar filtros
		System.out.println("Escolha um Tipo disponivel");
		this.mostraOpcao(Tipo.class);
		System.out.println("Informe uma ID(numeral)");
		return Tipo
				.valueOf(getGenericsEnumByCode(Tipo.class, this.sc.nextInt()));
	}

	/**
	 * getCor Mostra uma lista valida de Cor
	 * 
	 * @return Objeto Cor
	 */
	private Cor getCor() {
		// @TODO colocar filtros
		System.out.println("Escolha uma Cor disponivel");
		this.mostraOpcao(Cor.class);
		System.out.println("Informe uma ID(numeral)");
		return Cor.valueOf(getGenericsEnumByCode(Cor.class, this.sc.nextInt()));
	}

	/**
	 * getCambio Mostra uma lista valida de Cambio
	 * 
	 * @return Objeto Cambio
	 */
	private Cambio getCambio() {
		// @TODO colocar filtros
		System.out.println("Escolha um Cambio disponivel");
		this.mostraOpcao(Cambio.class);
		System.out.println("Informe uma ID(numeral)");
		return Cambio.valueOf(getGenericsEnumByCode(Cambio.class,
				getNumeroFromTerminal()));
	}

	/**
	 * mostraOpcao mostra opções de um enum de forma generica
	 * 
	 * @param enumClass
	 *            classe de um enum
	 */
	private <T extends Enum<T>> void mostraOpcao(Class<T> enumClass) {
		for (Enum<T> item : enumClass.getEnumConstants()) {
			// Mostra valor -> representacao
			System.out.println((item.ordinal() + 1) + "->" + item.toString());
		}
	}

	/**
	 * getGenericsEnumByCode retorna um enum generico pelo codigo
	 * 
	 * @param enumClass
	 *            classe de um enum
	 * @param code
	 *            valor que apontado pelo enum
	 */
	private <T extends Enum<T>> String getGenericsEnumByCode(
			Class<T> enumClass, int code) {
		for (Enum<T> item : enumClass.getEnumConstants()) {
			if (item.ordinal() == (code - 1)) {
				return item.toString();
			}
		}
		throw new RuntimeException("Id não encontrada");

	}

	public ModelLoja getModelLoja() {
		return modelLoja;
	}

	public void setModelLoja(ModelLoja modelLoja) {
		this.modelLoja = modelLoja;
	}

}
