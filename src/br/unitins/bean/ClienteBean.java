package br.unitins.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.ejb.ClienteEJB;
import br.unitins.model.Cliente;

@Named
@SessionScoped
public class ClienteBean implements Serializable{
	
	@EJB
	private ClienteEJB clienteEJB; 
	
	private Integer idPesquisar;
	
	private Cliente cliente;
	
	private List<Cliente> listaCliente;
	
	@PostConstruct
	public void init() {
		listaCliente = clienteEJB.findAll();
	}
	
	public String inserir() {
		clienteEJB.insert(cliente);
		listaCliente = clienteEJB.findAll();
		return null;
	}
	
	public String alterar() {
		clienteEJB.update(cliente);
		listaCliente = clienteEJB.findAll();
		return null;
	}
	public String apagar() {
		clienteEJB.delete(cliente);
		listaCliente = clienteEJB.findAll();
		return null;
	}
	
	public String novo() {
		cliente = new Cliente();
		return null;
	}
	
	public String buscaId() {
		cliente = clienteEJB.load(idPesquisar);
		return null;
	}
	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public Integer getIdPesquisar() {
		return idPesquisar;
	}

	public void setIdPesquisar(Integer idPesquisa) {
		this.idPesquisar = idPesquisa;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	
	

}
