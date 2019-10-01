package br.unitins.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.ejb.ProdutoEJB;
import br.unitins.model.Produto;

@Named
@SessionScoped
public class ProdutoBean implements Serializable{
	
	@EJB
	private ProdutoEJB produtoEJB;
	
	private Produto produto;
	
	private Integer idPesquisar;
	
	private List<Produto> listaProduto;
	
	@PostConstruct
	//Este metodo vai iniciar quando o projeto rodar, ou seja ele so é executado uma vez
	public void init() {
		// essa é uma cosulta no banco de dados "select"
		listaProduto = produtoEJB.findAll();
	}
	
	public String inserir() {
		produtoEJB.insert(produto);
		//atualizar o datadable
		listaProduto = produtoEJB.findAll();
		return null;
	}
	public String alterar() {
		produtoEJB.update(produto);
		//atualizar o datadable
		listaProduto = produtoEJB.findAll();
		return null;
	}
	public String apagar() {
		produtoEJB.delete(produto);
		//atualizar o datadable
		listaProduto = produtoEJB.findAll();
		return null;
	}
	public String novo() {
		produto = new Produto();
		return null;
	}
	
	public String buscaId() {
		produto = produtoEJB.load(idPesquisar);
		return null;
	}
	
	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public ProdutoEJB getProdutoEJB() {
		return produtoEJB;
	}

	public void setProdutoEJB(ProdutoEJB produtoEJB) {
		this.produtoEJB = produtoEJB;
	}

	public Integer getIdPesquisar() {
		return idPesquisar;
	}

	public void setIdPesquisar(Integer idPesquisar) {
		this.idPesquisar = idPesquisar;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}

