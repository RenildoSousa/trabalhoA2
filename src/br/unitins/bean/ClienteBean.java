package br.unitins.bean;

import java.io.Serializable;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.ejb.ClienteEJB;
import br.unitins.model.Cliente;

@Named
@RequestScoped
public class ClienteBean implements Serializable{
	
	@EJB
	private ClienteEJB clienteEJB; 
	
	private Cliente cliente;
	
	public String inserir() {
		clienteEJB.insert(cliente);
		return null;
	}
	
	public String alterar() {
		clienteEJB.update(cliente);
		return null;
	}
	public String apagar() {
		clienteEJB.delete(cliente);
		return null;
	}
	
	public String novo() {
		cliente = new Cliente();
		return null;
	}
	
	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

}
