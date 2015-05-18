package br.aplicacao;

import br.aplicacao.loja.CriadorDeLoja;

public class Menu2 {

	
	public Menu2(){
		this.pergunta = new PerguntaParaUsuario();
	}
	
	public static void main(String[] args) {
		new Menu2().configuraLoja();
	}
	
	private void configuraLoja() {
		
		int resposta = pergunta.criarOuEscolherLoja();
		
		if (resposta == CRIA)
			new CriadorDeLoja().criaComPerguntas();
		else if (resposta == ESCOLHE)
			System.out.println();
		
		
 	}
	
	
	private void escolheOpcao(){
		
		
	}
}
