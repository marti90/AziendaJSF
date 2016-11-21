package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelBean.BustaPaga;
import modelBean.Dipendente;
import service.Gestione;

@ManagedBean(name="bustaPagaController",eager=true)
@SessionScoped
public class BustaPagaController {
	
	private Gestione g;
	
	public BustaPagaController(){
		g= new Gestione();
	}
	
	public String registraBustaPaga(BustaPaga b){
	    	Dipendente d=g.getBustaConId(b.getId_busta()).getDipendente();
	    	b.setDipendente(d);
	    	g.registraBusta(b);
	    	return "HomePageAdmin?faces-reidrect-true";
	    }

}
