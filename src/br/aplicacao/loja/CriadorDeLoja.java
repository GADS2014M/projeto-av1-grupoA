package br.aplicacao.loja;

import br.aplicacao.PerguntaParaUsuario;
import br.aplicacao.modelos.ModelLoja;

public class CriadorDeLoja {

	/**
	 * Padrão de projetos Builder
	 */

	private PerguntaParaUsuario pergunta;
	private ModelLoja loja;

	/*
	 * Construtor de Criador de loja
	 */
	public CriadorDeLoja() {
		this.pergunta = new PerguntaParaUsuario();
		this.loja = new ModelLoja();
	}

	/**
	 *  Cria loja fazendo perguntas ao usuario
	 * @return Objeto Modelloja
	 */
	public ModelLoja criaComPerguntas() {
		String nome = this.pergunta.qualNomeDaLoja();
		String endereco = this.pergunta.qualEnderecoDaLoja();
		return this.nome(nome).em(endereco).salva().getLoja();
	}

	/**
	 * Seta o nome da loja
	 * 
	 * @param nome
	 * @return self
	 */
	public CriadorDeLoja nome(String nome) {
		this.loja.setNome(nome);
		return this;
	}

	/**
	 * Seta endereço de loja
	 * 
	 * @param endereco
	 * @return self
	 */
	public CriadorDeLoja em(String endereco) {
		loja.setEndereco(endereco);
		return this;
	}

	/**
	 * Salva na amazon a loja
	 * 
	 * @return self
	 */
	private CriadorDeLoja salva() {
		// @TODO talvez aqui seja legal salvar no db
		return this;
	}

	/**
	 * Retorna objeto modelLoja
	 * 
	 * @return retorna um objeto de modelLoja
	 */
	public ModelLoja getLoja() {
		return this.loja;
	}

}
