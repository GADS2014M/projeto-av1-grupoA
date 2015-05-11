package br.model.enums;

public enum Tipo {
	SEDAN(1),HATCH(2),COUPE(3);

	private final int opcao;


	private Tipo(int escolha) {
		this.opcao = escolha;
	}


	public int getOpcao() {
		return opcao;
	}
	

}
