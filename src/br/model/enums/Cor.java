package br.model.enums;

public enum Cor {
	AZUL(1),PRETO(2),BRANCO(3);

	private final int opcao;


	private Cor(int escolha) {
		this.opcao = escolha;
	}


	public int getOpcao() {
		return opcao;
	}



}
