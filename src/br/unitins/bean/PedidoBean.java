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

	private List<Produto> produtos;

	private List<Pedido> pedidos;

	private List<Cliente> clientes;

	private List<Pagamento> pagamentos;

	@PostConstruct
	public void init() {
		pedidos = pedidoEJB.findAll();
		setPagamentos(pagamentoEJB.findAll());
		setClientes(clienteEJB.findAll());
		setProdutos(produtoEJB.findAll());
	}

	public String insert() {
		pedidoEJB.insert(pedido, idCliente, idPagamento, idProduto);
		pedidoEJB.insert(pedido, idCliente, idPagamento, idProduto);
		limpar();
		br.unitins.bean.Util.redirect("pedido.xhtml");
		return null;
	}

	public String update() {
		pedido.setId(getIdPesquisa());
		pedidoEJB.update(pedido);
		limpar();
		br.unitins.bean.Util.redirect("pedido.xhtml");
		return null;
	}

	public String delete() {
		pedidoEJB.delete(pedidoEJB.load(idPesquisa));
		limpar();
		br.unitins.bean.Util.redirect("pedido.xhtml");
		return null;
	}

	public String pesquisar() {
		pedido = pedidoEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		pedido = new Pedido();
		return null;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Integer> getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(List<Integer> idProduto) {
		this.idProduto = idProduto;
	}
	

}
