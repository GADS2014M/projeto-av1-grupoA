package loja.veiculo;

public class Carro {
	
	private String chassi;
	private int montadora;
	private String modelo;
	private int tipo;
	private int cor;
	private float motorizacao;
	private int cambio;
	private float valorCarro;
	
	public float getValorCarro() {
		return valorCarro;
	}
	public void setValorCarro(float valorCarro) {
		this.valorCarro = valorCarro;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public int getMontadora() {
		return montadora;
	}
	public void setMontadora(int montadora) {
		this.montadora = montadora;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getCor() {
		return cor;
	}
	public void setCor(int cor) {
		this.cor = cor;
	}
	
	public float getMotorizacao() {
		return motorizacao;
	}
	public void setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}
	
	public int getCambio() {
		return cambio;
	}
	public void setCambio(int cambio) {
		this.cambio = cambio;
	}
	
	
	
}
