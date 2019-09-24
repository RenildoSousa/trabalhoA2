package br.unitins.ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Produto;

@Stateful
public class ProdutoEJB {
	   
	
	
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Produto produto) {
		em.persist(produto);
	}
	public void update(Produto produto) {
		em.merge(produto);
	}
	public void delete(Produto produto) {
		produto = load(produto.getId());
		em.remove(produto);
	}
	public Produto load(Integer id) {
		return em.find(Produto.class, id);
	}
}