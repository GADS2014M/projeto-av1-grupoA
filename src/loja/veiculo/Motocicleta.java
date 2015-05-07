package loja.veiculo;

import loja.veiculo.types.Chassi;
import loja.veiculo.types.Cor;
import loja.veiculo.types.Modelo;
import loja.veiculo.types.Montadora;
import loja.veiculo.types.Tipo;

public class Motocicleta {
	
	
	/**
	 * Classe Motocicleta Define uma motocicleta
	 *@author isvaldo,Yan
	 *@param chassi enumeração para chassi
	 *@param montadora enumeração para montadora
	 *@param modelo enumeração para modelo
	 *@param tipo enumeração para tipo
	 *@param cor enumeração para cor
	 *@param cilindrada inteiro para cilindrada
	 *@param cambio enumeração para cambio
	 *@param capacidadeDoTanque valor 0-127L para tanque
	 *@param valor preço da moto
	 * */
	
	private Chassi chassi;
	private Montadora montadora;
	private Modelo modelo;
	private Tipo tipo;
	private Cor cor;
	private int cilindrada;
	private byte capacidadeDoTanque;
	private float valor;
	
	
	/**
	 * criaMoto cria um objeto moto
	 *@param chassi enumeração para chassi
	 *@param montadora enumeração para montadora
	 *@param modelo enumeração para modelo
	 *@param tipo enumeração para tipo
	 *@param cor enumeração para cor
	 *@param cilindrada inteiro para cilindrada
	 *@param cambio enumeração para cambio
	 *@param capacidadeDoTanque valor 0-127L para tanque
	 *@param valor preço da moto
	 *@return objeto Motocicleta
	 */
	public static Motocicleta criaMoto(Chassi chassi,             
			Montadora montadora,       
			Modelo modelo,             
			Tipo tipo,                 
			Cor cor,                   
			int cilindrada,            
			byte capacidadeDoTanque,   
			float valor) {
		//TODO adicionar filtros
		Motocicleta moto = new Motocicleta();
		moto.setChassi(chassi);
		moto.setMontadora(montadora);
		moto.setModelo(modelo);
		moto.setTipo(tipo);
		moto.setCor(cor);
		moto.setCilindrada(cilindrada);
		moto.setCapacidadeDoTanque(capacidadeDoTanque);
		moto.setValor(valor);
		return moto;
	}
	
              
	@Override
	public String toString() {
		return "Motocicleta [chassi=" + chassi + ", montadora=" + montadora
				+ ", modelo=" + modelo + ", tipo=" + tipo + ", cor=" + cor
				+ ", cilindrada=" + cilindrada + ", capacidadeDoTanque="
				+ capacidadeDoTanque + ", valor=" + valor + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidadeDoTanque;
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + cilindrada;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result
				+ ((montadora == null) ? 0 : montadora.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motocicleta other = (Motocicleta) obj;
		if (capacidadeDoTanque != other.capacidadeDoTanque)
			return false;
		if (chassi != other.chassi)
			return false;
		if (cilindrada != other.cilindrada)
			return false;
		if (cor != other.cor)
			return false;
		if (modelo != other.modelo)
			return false;
		if (montadora != other.montadora)
			return false;
		if (tipo != other.tipo)
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}


	// get e set
	public Chassi getChassi() {
		return chassi;
	}
	public void setChassi(Chassi chassi) {
		this.chassi = chassi;
	}
	public Montadora getMontadora() {
		return montadora;
	}
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public byte getCapacidadeDoTanque() {
		return capacidadeDoTanque;
	}
	public void setCapacidadeDoTanque(byte capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	// fim get e set
}
