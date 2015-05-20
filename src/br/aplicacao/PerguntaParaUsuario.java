package br.aplicacao;

import br.aplicacao.modelos.ModelLoja;
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
				.next("1) Criar uma nova loja")
				.next("2) Escolher uma loja já existente");
		return daTela.nextInt();
	}

	public String qualNomeDaLoja() {
		naTela.mostraTexto("Qual Nome da loja ?");
		return daTela.nextString();
	}

	public String qualEnderecoDaLoja() {
		naTela.mostraTexto("Qual endereço da loja ?");
		return daTela.nextString();
	}

	public InputClass getDaTela() {
		return daTela;
	}

	public void setDaTela(InputClass daTela) {
		this.daTela = daTela;
	}

	public OutputClass getNaTela() {
		return naTela;
	}

	public void setNaTela(OutputClass naTela) {
		this.naTela = naTela;
	}

	public ModelLoja QualLoja() {
		//Seleciona loja e retorna um objeto
		return new ModelLoja(null, null);
	}
	

}
