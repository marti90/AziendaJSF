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

import modelBean.Dipendente;
import service.Gestione;

@ManagedBean(name="dipendenteController",eager=true)
@SessionScoped
public class DipendenteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Dipendente> listaDipendenti;
	
	public DipendenteController(){
		
	}
	
	@PostConstruct
	public void init(){
		setG(new Gestione());
		listaDipendenti = new ArrayList<Dipendente>();
	}

	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}

	public List<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}

	public void setListaDipendenti(List<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}
	
	public String registraDipendente(Dipendente d){
		g.registraDipendente(d);
		return "HomePageAdmin";
	}
	
	public String cancellaDipendente(String username){
		Dipendente d = g.getDipendenteConUsername(username);
		g.eliminaDipendente(d);
		return "HomePageAdmin?faces-redirect=true";
	}
	
	public String aggiornaDipendente(Dipendente d){
		g.modificaDipendente(d);
		return "HomePageAdmin?faces-redirect=true";
	}
	
    public String modificaDipendente(String username){
    	Dipendente dipendente = g.getDipendenteConUsername(username);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap= context.getRequestMap();
		requestMap.put("d", dipendente);
		
		return "modificaDipendente";
				
	}
	
}
