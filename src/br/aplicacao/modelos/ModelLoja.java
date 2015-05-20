package br.aplicacao.modelos;

import java.util.List;

import br.aplicacao.PerguntaParaUsuario;
import br.aplicacao.loja.CriadorDeLoja;


public class ModelLoja {
	protected String nome;
	protected String endereco;
	
	protected List<ModelCarro> carros;
	protected List<ModelMoto> motos;
	
	
	public ModelLoja(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public ModelLoja configuraLojaPeloUsuario() {
		int CRIA = 1;
		int ESCOLHE = 2;
		PerguntaParaUsuario pergunta = new PerguntaParaUsuario();
		int resposta = pergunta.criarOuEscolherLoja();
		if (resposta == CRIA)
			return new CriadorDeLoja().criaComPerguntas();
		else if (resposta == ESCOLHE)
			//@Cria uma classe para selecionar coisas do banco
			System.out.println("dummy ");
		else
			System.out.println("perguntar denovo");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
