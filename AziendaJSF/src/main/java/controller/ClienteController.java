package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import modelBean.Cliente;
import service.Gestione;

@ManagedBean(name="clienteController",eager=true)
@SessionScoped
public class ClienteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Cliente> listaClienti;
	
	public ClienteController(){
		
	}
	
	@PostConstruct
	public void init(){
		setG(new Gestione());
		listaClienti = new ArrayList<Cliente>();
	}

	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}

	public List<Cliente> getListaClienti() {
		return listaClienti;
	}

	public void setListaClienti(List<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}
	
	public String registraCliente(Cliente c){
		g.registraCliente(c);
		return "HomePageAdmin";
	}
	
	public String cancellaCliente(String username){
		Cliente c = g.getClienteConUsername(username);
		g.eliminaCliente(c);
		return "HomePageAdmin?faces-redirect=true";
	}
	
	public String aggiornaCliente(Cliente c){
		g.modificaCliente(c);
		return "HomePageAdmin?faces-redirect=true";
	}
	
    public String modificaCliente(String username){
		Cliente cliente = g.getClienteConUsername(username);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap= context.getRequestMap();
		requestMap.put("c", cliente);
		
		return "modificaCliente";
				
	}
	
}
