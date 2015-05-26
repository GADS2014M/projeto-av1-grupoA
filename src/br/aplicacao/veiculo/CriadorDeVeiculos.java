package br.aplicacao.veiculo;

import br.aplicacao.PerguntaParaUsuario;
import br.aplicacao.util.OutputClass;

public class CriadorDeVeiculos {

	private static final int CARRO = 1;
	private static final int MOTO = 2;
	private int veiculo;
	private PerguntaParaUsuario pergunta;
	
	public CriadorDeVeiculos getTipoDoVeiculo() {
		this.pergunta = new PerguntaParaUsuario();

		int escolha = this.pergunta.PeguntaTipoDeVeiculo();
		if (escolha == CARRO)
			this.veiculo = CARRO;
		else if (escolha == MOTO) {
			this.veiculo = MOTO;
		} else {
			new OutputClass().mostraErro("Opção invalida");
			return getTipoDoVeiculo();
		}
		return getTipoDoVeiculo();
	}






	public void criaVeiculo() {
		
		if(this.veiculo == CARRO){
			this.pergunta.comoCriaCarro();
		}else if(this.veiculo == MOTO){
			this.pergunta.comoCriaMoto();
		}
	}
}
