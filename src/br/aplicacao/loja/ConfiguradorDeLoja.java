package br.aplicacao.loja;

import br.aplicacao.PerguntaParaUsuario;
import br.aplicacao.modelos.ModelLoja;

public class ConfiguradorDeLoja {
	public final static int CRIA = 1;
	public final static int ESCOLHE = 2; 
	private PerguntaParaUsuario pergunta;

	public ConfiguradorDeLoja() {
		this.pergunta = new PerguntaParaUsuario();
	}

	public ModelLoja retornaLoja() {
		int resposta = pergunta.criarOuEscolherLoja();

		if (resposta == CRIA)
			return new CriadorDeLoja().criaComPerguntas();
		else if (resposta == ESCOLHE)
			//@TODO Cria uma classe para selecionar coisas do banco
			System.out.println("dummy ");
		else
			System.out.println("perguntar denovo");
	}

}
