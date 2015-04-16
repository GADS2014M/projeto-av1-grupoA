package loja.veiculo.types;

public enum Cambio {
	MANUAL(1),SEMIAUTOMATICO(2),AUTOMATICO(3);

	private final int opcao;


	private Cambio(int escolha) {
		this.opcao = escolha;
	}


	public int getOpcao() {
		return opcao;
	}




}
