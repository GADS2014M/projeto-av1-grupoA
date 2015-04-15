package loja.veiculo;

public class Carro {
	
	private String chassi;
	private int montadora;
	private String modelo;
	private int tipo;
	private int cor;
	private float motorização;
	private int câmbio;
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
	
	public float getMotorização() {
		return motorização;
	}
	public void setMotorização(float motorização) {
		this.motorização = motorização;
	}
	
	public int getCâmbio() {
		return câmbio;
	}
	public void setCâmbio(int câmbio) {
		this.câmbio = câmbio;
	}
	
	
	
}
