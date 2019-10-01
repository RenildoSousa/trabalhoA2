package br.unitins.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.ejb.PagamentoEJB;
import br.unitins.ejb.TipoPagamentoEJB;
import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;

@Named
@SessionScoped
public class PagamentoBean implements Serializable {

	@EJB
	private PagamentoEJB pagamentoEJB;

	@EJB
	private TipoPagamentoEJB tipoPagamentoEJB;
	
	private Pagamento pagamento;

	private Integer idPesquisar;
	
	private Integer idTipoPagamento;
	
	private Integer idPagamento;
	
	private List<TipoPagamento> listaTipoPagamento;
	
	public List<TipoPagamento> getListaTipoPagamento() {
		return listaTipoPagamento;
	}

	public void setListaTipoPagamento(List<TipoPagamento> listaTipoPagamento) {
		this.listaTipoPagamento = listaTipoPagamento;
	}

	private List<Pagamento> listaPagamento;

	@PostConstruct
	public void init() {
		// essa é uma cosulta no banco de dados "select"
		listaPagamento = pagamentoEJB.findAll();
		setListaTipoPagamento(tipoPagamentoEJB.findAll());
	}

	public String inserir() {
		pagamentoEJB.insert(pagamento, idTipoPagamento);
		listaPagamento = pagamentoEJB.findAll();
		return null;
	}

	public String alterar() {
		getPagamento().getTipoPagamento().setId(idTipoPagamento);
		pagamentoEJB.update(pagamento);
		listaPagamento = pagamentoEJB.findAll();
		return null;
	}

	public String apagar() {
		pagamentoEJB.delete(pagamento);
		listaPagamento = pagamentoEJB.findAll();
		return null;
	}

	public String novo() {
		pagamento = new Pagamento();
		return null;
	}

	public String buscaId() {
		pagamento = pagamentoEJB.load(idPesquisar);
		return null;
	}
	

	public PagamentoEJB getPagamentoEJB() {
		return pagamentoEJB;
	}

	public void setPagamentoEJB(PagamentoEJB pagamentoEJB) {
		this.pagamentoEJB = pagamentoEJB;
	}

	public Pagamento getPagamento() {
		if (pagamento == null) {
			pagamento = new Pagamento();
		}
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Integer getIdPesquisar() {
		return idPesquisar;
	}

	public void setIdPesquisar(Integer idPesquisar) {
		this.idPesquisar = idPesquisar;
	}

	public List<Pagamento> getListaPagamento() {
		return listaPagamento;
	}

	public void setListaPagamento(List<Pagamento> listaPagamento) {
		this.listaPagamento = listaPagamento;
	}

	public Integer getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(Integer idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	

}
