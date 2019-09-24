package br.unitins.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.ejb.TipoPagamentoEJB;
import br.unitins.model.TipoPagamento;

@Named
@RequestScoped
public class TipoPagamentoBean {
	
	@EJB
	private TipoPagamentoEJB tipoPagamentoEJB;
	
	private TipoPagamento tipoPagamento;
	
	public String inserir() {
		tipoPagamentoEJB.insert(tipoPagamento);
		return null;
	}
	public String alterar() {
		tipoPagamentoEJB.update(tipoPagamento);
		return null;
	}
	public String apagar() {
		tipoPagamentoEJB.delete(tipoPagamento);
		return null;
	}
	public String novo() {
		tipoPagamento = new TipoPagamento();
		return null;
	}
	public TipoPagamento getProduto() {
		if (tipoPagamento == null) {
			tipoPagamento = new TipoPagamento();
		}
		return tipoPagamento;
	}

}
