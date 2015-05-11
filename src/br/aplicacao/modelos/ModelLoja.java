package br.aplicacao.modelos;

import java.util.List;

import javax.persistence.Query;

import br.model.Carro;
import br.model.Loja;
import br.model.Moto;
import br.model.dao.DAO;

public class ModelLoja {
	private Loja loja;
	private List<Carro> carros;
	private List<Moto> motos;
	
	public ModelLoja() {
		atualizaEstoque();
	}

	/**
	 * Atualiza estoque
	 */
	public void atualizaEstoque() {
		// abre conexão
		DAO db = new DAO();
		// busca todos carros e motos
		Query queryCarro = db.getConnection().createQuery("from Carro");
		Query QueryMoto = db.getConnection().createQuery("from Moto");
		// coloca em uma lista
		this.setCarros(queryCarro.getResultList());
		this.setMotos(QueryMoto.getResultList());
		// fecha conexão
		db.close();
	}

	public void criaLoja(String nome, String endereco) {
		DAO db = new DAO();
		Loja loja = new Loja();
		loja.setNome(nome);
		loja.setEndereco(endereco);
		db.getConnection().persist(loja);
		db.close();
		this.setLoja(loja);
	}

	public void saveAmazon() {
		// Salva loja na amazon
		DAO db = new DAO();
		db.getEm().persist(this.getLoja());
		db.close();
	}

	public void getLojas() {
		DAO db = new DAO();
		db.getEm().createQuery("from Loja;");
		db.close();
	}

	public void AddCarro(Carro carro) {
		this.getCarros().add(carro);
	}

	public void AddMoto(Moto moto) {
		this.getMotos().add(moto);
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public List<Moto> getMotos() {
		return motos;
	}

	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
