package br.unitins.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Cliente;
import br.unitins.model.Pedido;
import br.unitins.model.Produto;

@Stateful
public class PedidoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Pedido pedido) {
		em.persist(pedido);
	}
	public void upadate(Pedido pedido) {
		em.merge(pedido);
	}
	public void delete(Pedido pedido) {
		pedido = load(pedido.getId());
		em.remove(pedido);
	}
	public Pedido load(Integer id) {
		return em.find(Pedido.class, id);
	}
	public List<Pedido> findAll(){
		 return em.createQuery("select p from pedido p", Pedido.class).getResultList();
	 }

}
