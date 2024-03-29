package br.unitins.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Cliente;

@Stateful
public class ClienteEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public void delete(Cliente cliente) {
		cliente = load(cliente.getId());
		em.remove(cliente);
	}
	
	public Cliente load(Integer id) {
		return em.find(Cliente.class, id);
	}
	 public List<Cliente> findAll(){
		 return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	 }

}
