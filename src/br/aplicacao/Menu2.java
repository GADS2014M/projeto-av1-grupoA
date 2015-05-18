package br.aplicacao;

public class Menu2 {
	public final static int CRIA = 1;
	public final static int ESCOLHE = 2; 
	private PerguntaParaUsuario pergunta;

	
	public Menu2(){
		this.pergunta = new PerguntaParaUsuario();
	}
	
	public static void main(String[] args) {
		new Menu2().configuraLoja();
	}
	
	private void configuraLoja() {
		
		int resposta = pergunta.criarOuEscolherLoja();
		
		if (resposta == CRIA)
			System.out.println();
		else if (resposta == ESCOLHE)
			System.out.println();
		
		
 	}
	
	
	private void escolheOpcao(){
		
		
	}
}
