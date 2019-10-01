package br.unitins.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import com.sun.faces.util.Util;

import br.unitins.ejb.ClienteEJB;
import br.unitins.ejb.PagamentoEJB;
import br.unitins.ejb.PedidoEJB;
import br.unitins.ejb.ProdutoEJB;
import br.unitins.model.Cliente;
import br.unitins.model.Pagamento;
import br.unitins.model.Pedido;
import br.unitins.model.Produto;

@Named
@SessionScoped
public class PedidoBean implements Serializable{
	
	@EJB
	private PedidoEJB pedidoEJB;

	@EJB
	private ClienteEJB clienteEJB;

	@EJB
	private PagamentoEJB pagamentoEJB;

	@EJB
	private ProdutoEJB produtoEJB;

	private Pedido pedido;

	private Integer idPesquisa;

	private Integer idCliente;

	private Integer idPagamento;

	private List<Integer> idProduto = new ArrayList<>();

	private List<Produto> listaProduto;

	private List<Pedido> listaPedido;

	private List<Cliente> listaCliente;

	private List<Pagamento> listaPagamento;

	@PostConstruct
	public void init() {
		listaPedido = pedidoEJB.findAll();
		setListaPagamento(pagamentoEJB.findAll());
		setListaCliente(clienteEJB.findAll());
		setListaProduto(produtoEJB.findAll());
	}

	public String inserir() {
		pedidoEJB.insert(pedido, idCliente, idPagamento, idProduto);
		return null;
	}

	public String alterar() {
		pedidoEJB.update(pedido);
		return null;
	}

	public String apagar() {
		pedidoEJB.delete(pedidoEJB.load(idPesquisa));
		return null;
	}

	public String buscaId() {
		pedido = pedidoEJB.load(idPesquisa);
		return null;
	}

	public String novo() {
		pedido = new Pedido();
		return null;
	}


	public Pedido getPedido() {

		if (pedido == null) {
			pedido = new Pedido();
		}

		return pedido;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public List<Integer> getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(List<Integer> idProduto) {
		this.idProduto = idProduto;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<Pagamento> getListaPagamento() {
		return listaPagamento;
	}

	public void setListaPagamento(List<Pagamento> listaPagamento) {
		this.listaPagamento = listaPagamento;
	}
	

}
