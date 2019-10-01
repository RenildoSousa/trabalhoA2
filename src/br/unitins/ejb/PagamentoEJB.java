package br.unitins.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Cliente;
import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;

@Stateful
public class PagamentoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Pagamento pagamento, Integer idTipoPagamento) {
		pagamento.setTipoPagamento(em.find(TipoPagamento.class, idTipoPagamento));
		em.persist(pagamento);
	}
	public void update(Pagamento pagamento, Integer idTipoPagamento) {
		em.merge(pagamento);
	}
	public void delete(Pagamento pagamento) {
		pagamento = load(pagamento.getId());
		em.remove(pagamento);
	}
	public Pagamento load(Integer id) {
		return em.find(Pagamento.class, id);
	}
	public List<Pagamento> findAll(){
		 return em.createQuery("select p from Pagamento p", Pagamento.class).getResultList();
	 }


}
