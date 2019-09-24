package br.unitins.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestMap;
import javax.inject.Named;

import br.unitins.ejb.PedidoEJB;
import br.unitins.model.Cliente;
import br.unitins.model.Pedido;

@Named
@RequestScoped
public class PedidoBean {
	
	@EJB
	private PedidoEJB pedidoEJB;
	
	private Pedido pedido;
	
	private Integer idClinte;
	private Integer idProduto;
	private Integer idPagamento;
	
	public String inserir() {
		pedidoEJB.insert(pedido);
		return null;
	}
	
	public String alterar() {
		pedidoEJB.upadate(pedido);
		return null;
	}
	public String apagar() {
		pedidoEJB.delete(pedido);
		return null;
	}
	
	public String novo() {
		pedido = new Pedido();
		return null;
	}

	public PedidoEJB getPedidoEJB() {
		return pedidoEJB;
	}

	public void setPedidoEJB(PedidoEJB pedidoEJB) {
		this.pedidoEJB = pedidoEJB;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getIdClinte() {
		return idClinte;
	}

	public void setIdClinte(Integer idClinte) {
		this.idClinte = idClinte;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	

}
