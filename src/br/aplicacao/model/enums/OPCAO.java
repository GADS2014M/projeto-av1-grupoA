package br.aplicacao.model.enums;

public enum OPCAO {
	CriarVeiculo(1),
	PesquisarVeiculo(2),
	ListarVeiculo(3);

	private final int opcao;

	private OPCAO(int escolha) {
		this.opcao = escolha;
		
	}

	public int getOpcao() {
		return opcao;
	}
}
