package br.unitins.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Cliente;
import br.unitins.model.Pedido;
import br.unitins.model.Pagamento;

@Stateful
public class PedidoEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Pedido pedido, Integer idCliente, Integer idPagamento, List<Integer> idProduto) {
		pedido.setCliente(em.find(Cliente.class, idCliente));
		pedido.setPagamento(em.find(Pagamento.class, idPagamento));

		em.persist(pedido);
	}

	public void update(Pedido pedido) {
		em.merge(pedido);
	}

	public void delete(Pedido pedido) {
		pedido = load(pedido.getId());
		em.remove(pedido);
	}

	public Pedido load(Integer id) {
		return em.find(Pedido.class, id);
	}

	public List<Pedido> findAll() {
		return em.createQuery("select pe from Pedido pe", Pedido.class).getResultList();
	}
}
