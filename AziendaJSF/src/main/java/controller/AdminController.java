package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelBean.Admin;
import service.Gestione;

@ManagedBean(name="adminController",eager=true)
@SessionScoped
public class AdminController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Admin> listaAdmin;
	
	public AdminController(){
		
	}
	
	@PostConstruct
	public void init(){
		setG(new Gestione());
		listaAdmin = new ArrayList<Admin>();
	}

	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}

	public List<Admin> getListaAdmin() {
		return listaAdmin;
	}

	public void setListaAdmin(List<Admin> listaAdmin) {
		this.listaAdmin = listaAdmin;
	}
	
}
