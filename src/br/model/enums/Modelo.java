package br.model.enums;

public enum Modelo {
	MODELOA(1),MODELOB(2),MODELOC(3);

	private final int opcao;


	private Modelo(int escolha) {
		this.opcao = escolha;
	}


	public int getOpcao() {
		return opcao;
	}
}
