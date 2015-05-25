package br.aplicacao.loja;

import java.util.ArrayList;
import java.util.List;

import br.aplicacao.PerguntaParaUsuario;
import br.aplicacao.modelos.ModelLoja;
import br.aplicacao.util.InputClass;
import br.aplicacao.util.OutputClass;
import br.model.Loja;

public class ConfiguradorDeLoja {
	public final static int CRIA = 1;
	public final static int ESCOLHE = 2; 
	private PerguntaParaUsuario pergunta;

	public ConfiguradorDeLoja() {
		this.pergunta = new PerguntaParaUsuario();
	}

	public Loja pedeConfiguracaoDoUsuario() {
		int resposta = pergunta.criarOuEscolherLoja();
		if (resposta == CRIA)
			return new CriadorDeLoja().criaComPerguntas();
		else if (resposta == ESCOLHE){
			ModelLoja lojaM = new ModelLoja(); 
			List<Loja> lojas = new ArrayList<Loja>();
			lojas = lojaM.getLojasDb();
			lojaM.mostraLojasNaTela(lojas);
			int escolha = new InputClass().nextInt();
			return lojas.get(escolha);
		}
		else
			new OutputClass().mostraErro("Opção invalida");
		return pedeConfiguracaoDoUsuario();
	}

}
