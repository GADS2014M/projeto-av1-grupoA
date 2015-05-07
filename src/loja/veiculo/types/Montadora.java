package loja.veiculo.types;

public enum Montadora {
	FIAT(1),HONDA(2),NISSAN(3);

	private final int opcao;


	private Montadora(int escolha) {
		this.opcao = escolha;
	}


	public int getOpcao() {
		return opcao;
	}
}
