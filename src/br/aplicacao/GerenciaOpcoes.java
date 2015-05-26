package br.aplicacao;

import br.aplicacao.model.enums.OPCAO;
import br.aplicacao.veiculo.CriadorDeVeiculos;

public class GerenciaOpcoes {
	
	
	private PerguntaParaUsuario pergunta;	

	public GerenciaOpcoes() {
		pergunta = new PerguntaParaUsuario();
	}
	
	public void abrirLoja() {
		OPCAO escolha = pergunta.PerguntaOpcaoMenu();
		
		switch (escolha) {
		case CriarVeiculo:
			new CriadorDeVeiculos().getTipoDoVeiculo().criaVeiculo();
			break;
		case PesquisarVeiculo:
			
			break;
		case ListarVeiculo:
			
			break;
			
		default:
			break;
		}
	}

	public void fecharLoja() {
		// TODO Auto-generated method stub
		
	}
	

}
