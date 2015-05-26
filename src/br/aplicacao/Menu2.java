package br.aplicacao;

import br.aplicacao.loja.ConfiguradorDeLoja;
import br.aplicacao.model.enums.OPCAO;
import br.aplicacao.util.OutputClass;
import br.model.Loja;

public class Menu2 {

	public Loja loja;
	private PerguntaParaUsuario pergunta;


	public Menu2(){
		this.pergunta = new PerguntaParaUsuario();
		this.configuraLoja();
		this.escolheOpcao();
	}
	
	public static void main(String[] args) {
		new Menu2();
	}
	
	private void configuraLoja() {
		loja = new ConfiguradorDeLoja().pedeConfiguracaoDoUsuario();
		new OutputClass().mostraTexto("Bem vindo a loja "+loja.getNome());
 	}
	
	
	private void escolheOpcao(){
		GerenciaOpcoes gerenciador = new GerenciaOpcoes();
		gerenciador.abrirLoja();
		gerenciador.fecharLoja();
	}
}
