package br.unitins.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestMap;
import javax.inject.Named;

import br.unitins.ejb.PagamentoEJB;
import br.unitins.model.Pagamento;

@Named
@RequestScoped
public class PagamentoBean implements Serializable{
	
	@EJB
	private PagamentoEJB pagamentoEJB;
	
	private Integer tipoPagamento;
	private Pagamento pagamento;
	
	public String inserir() {
		pagamentoEJB.insert(pagamento);
		return null;
	}
	
	public String alterar() {
		pagamentoEJB.update(pagamento);
		return null;
	}
	
	public String apagar() {
		pagamentoEJB.delete(pagamento);
		return null;
	}
	
	public String novo() {
		pagamento = new Pagamento();
		return null;
	}

	public PagamentoEJB getPagamentoEJB() {
		return pagamentoEJB;
	}

	public void setPagamentoEJB(PagamentoEJB pagamentoEJB) {
		this.pagamentoEJB = pagamentoEJB;
	}

	public Integer getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	

}
