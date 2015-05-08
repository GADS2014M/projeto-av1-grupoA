package br.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.model.enums.Chassi;
import br.model.enums.Cor;
import br.model.enums.Modelo;
import br.model.enums.Montadora;
import br.model.enums.Tipo;

@Entity
@Table(name="veiculo")
public class Veiculo {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="chassi")
	private Chassi chassi;
	
	@Enumerated(EnumType.STRING)
	@Column(name="montadora")
	private Montadora montadora;
	
	@Enumerated(EnumType.STRING)
	@Column(name="modelo")
	private Modelo modelo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo")
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="cor")
	private Cor cor;
	
	@Column(name="preco")
	private BigDecimal preco;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
