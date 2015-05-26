package br.aplicacao;

import java.math.BigDecimal;

import br.aplicacao.model.enums.OPCAO;
import br.aplicacao.modelos.ModelCarro;
import br.aplicacao.modelos.ModelLoja;
import br.aplicacao.util.InputClass;
import br.aplicacao.util.OutputClass;
import br.model.enums.Cambio;
import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Motorizacao;
import br.model.enums.Tipo;
import br.model.enums.UtilEnum;

public class PerguntaParaUsuario {
	private InputClass daTela;
	private OutputClass naTela;

	public PerguntaParaUsuario() {
		daTela = new InputClass();
		naTela = new OutputClass();
	}

	public int criarOuEscolherLoja() {
		naTela.mostraTexto("Bem vindo ao sistema")
				.next("1) Criar uma nova loja")
				.next("2) Escolher uma loja já existente");
		return daTela.nextInt();
	}

	public String qualNomeDaLoja() {
		naTela.mostraTexto("Qual Nome da loja ?");
		return daTela.nextString();
	}

	public String qualEnderecoDaLoja() {
		naTela.mostraTexto("Qual endereço da loja ?");
		return daTela.nextString();
	}

	public InputClass getDaTela() {
		return daTela;
	}

	public void setDaTela(InputClass daTela) {
		this.daTela = daTela;
	}

	public OutputClass getNaTela() {
		return naTela;
	}

	public void setNaTela(OutputClass naTela) {
		this.naTela = naTela;
	}

	public ModelLoja QualLoja() {
		//Seleciona loja e retorna um objeto
		return new ModelLoja(null, null);
	}

	public OPCAO PerguntaOpcaoMenu() {
		naTela.mostraTexto("Escolha uma ação");
		UtilEnum.mostraOpcao(OPCAO.class);
		int escolha= daTela.nextInt();
		String StrEnum = UtilEnum.getGenericsEnumByCode(OPCAO.class,escolha);
		return OPCAO.valueOf(StrEnum);
	}

	public int PeguntaTipoDeVeiculo() {
		naTela.mostraTexto("Qual tipo de veiculo? ")
		.next("1) Carro")
		.next("2) Moto");
		return daTela.nextInt();
	}

	public ModelCarro comoCriaCarro() {
		Chassi chassi = perguntaEnum(Chassi.class, "Chassi");
		Montadora montadora = perguntaEnum(Montadora.class, "Montadora");
		Modelo modelo = perguntaEnum(Modelo.class, "Modelo");
		Tipo tipo = perguntaEnum(Tipo.class, "Tipo");
		Cor cor = perguntaEnum(Cor.class, "Cor");
		Motorizacao motorizacao = perguntaEnum(Motorizacao.class, "Motorizacao");
		Cambio cambio = perguntaEnum(Cambio.class, "Cambio");
		BigDecimal valor = perguntaValor();
		ModelCarro carro = new ModelCarro(chassi, montadora, modelo, tipo, cor, motorizacao, cambio);
	}

	private BigDecimal perguntaValor() {
		new BigDecimal(this.sc.nextFloat());
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Enum<T>> T perguntaEnum(Class<T> enumClass,String nome) {
		naTela.mostraTexto("Qual "+nome+"disponivel");
		UtilEnum.mostraOpcao(enumClass);
		int escolha = daTela.nextInt();
		return (T) Chassi.valueOf(UtilEnum.getGenericsEnumByCode(enumClass,escolha));
	}

	
	
	

}
