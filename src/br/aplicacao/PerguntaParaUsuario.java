package br.aplicacao;

import br.aplicacao.util.InputClass;
import br.aplicacao.util.OutputClass;

public class PerguntaParaUsuario {
	private InputClass daTela;
	private OutputClass naTela;

	public PerguntaParaUsuario() {
		daTela = new InputClass();
		naTela = new OutputClass();
	}

	public int criarOuEscolherLoja() {
		naTela.mostraTexto("Bem vindo ao sistema")
				.next("1) Criar uma nova loja ?")
				.next("2) Escolher uma loja já existente");
		return daTela.nextInt();
	}

}
