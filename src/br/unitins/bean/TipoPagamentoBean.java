package br.unitins.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.ejb.TipoPagamentoEJB;
import br.unitins.model.TipoPagamento;

@Named
@SessionScoped
public class TipoPagamentoBean implements Serializable{
	
	@EJB
	private TipoPagamentoEJB tipoPagamentoEJB;
	
	private TipoPagamento tipoPagamento;
	
	private Integer idPesquisar;
	
	private List<TipoPagamento> listaTipoPagamento;
	
	@PostConstruct
	public void init() {
		listaTipoPagamento = tipoPagamentoEJB.findAll();
	}
	
	public String inserir() {
		tipoPagamentoEJB.insert(tipoPagamento);
		listaTipoPagamento = tipoPagamentoEJB.findAll();
		return null;
	}
	public String alterar() {
		tipoPagamentoEJB.update(tipoPagamento);
		listaTipoPagamento = tipoPagamentoEJB.findAll();
		return null;
	}
	public String apagar() {
		tipoPagamentoEJB.delete(tipoPagamento);
		listaTipoPagamento = tipoPagamentoEJB.findAll();
		return null;
	}
	public String novo() {
		tipoPagamento = new TipoPagamento();
		return null;
	}
	
	public String buscaId() {
		tipoPagamento = tipoPagamentoEJB.load(idPesquisar);
		return null;
	}
	
	public TipoPagamento getTipoPagamento() {
		if (tipoPagamento == null) {
			tipoPagamento = new TipoPagamento();
		}
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public Integer getIdPesquisar() {
		return idPesquisar;
	}
	public void setIdPesquisar(Integer idPesquisar) {
		this.idPesquisar = idPesquisar;
	}
	public List<TipoPagamento> getListaTipoPagamento() {
		return listaTipoPagamento;
	}
	public void setListaTipoPagamento(List<TipoPagamento> listaTipoPagamento) {
		this.listaTipoPagamento = listaTipoPagamento;
	}


}
