package br.aplicacao.modelos;

import java.util.List;

import javax.persistence.Query;

import br.aplicacao.util.OutputClass;
import br.model.Loja;
import br.model.dao.DAO;


public class ModelLoja {
	protected String nome;
	protected String endereco;
	
	protected List<ModelCarro> carros;
	protected List<ModelMoto> motos;
	
	
	public ModelLoja(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public ModelLoja(){
		
	}
	
	public void mostraLojasNaTela(List<Loja> lojas) {
		OutputClass naTela = new OutputClass();
		for (Loja loja : lojas){
			naTela.mostraTexto(loja.getId()+"->"+loja.getNome());
		}
	}
	
	public List<Loja> getLojasDb(){
		DAO db = new DAO();
		Query queryLojas = db.getConnection().createQuery("from Loja");
		return queryLojas.getResultList();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<ModelCarro> getCarros() {
		return carros;
	}

	public void setCarros(List<ModelCarro> carros) {
		this.carros = carros;
	}

	public List<ModelMoto> getMotos() {
		return motos;
	}

	public void setMotos(List<ModelMoto> motos) {
		this.motos = motos;
	}
	
	
	

}
