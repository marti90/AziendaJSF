package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import modelBean.Fattura;
import modelBean.FiltroFattura;
import client.InvocazioneFatture;

@ManagedBean(name="fatturaController",eager=true)
@SessionScoped
public class FatturaController {
	
	private InvocazioneFatture invocazione;
	private List<Fattura> listaFatture;
	private String codice;
	private Fattura fattura;
	
	public FatturaController(){
		invocazione= new InvocazioneFatture();
		setListaFatture(new ArrayList<Fattura>());
	}
	
	public Fattura richiestaFatturaConCodice(String codice1){
		
		System.out.println("Entrato");
		Response response = invocazione.richiestaFatturaConCodice(codice1)
                                       .invoke();
		fattura= response.readEntity(Fattura.class);
		System.out.println(fattura.getImporto());
        return fattura;
	}
	
	public String inviaFattura(Fattura f){
		
		Response response = invocazione.registraFattura(f)
				                       .invoke();
		
		if(response.getStatus()!=201){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La Fattura NON e' stata registrata correttamente"));
		}
		
		return "HomePageAdmin?faces-redirect=true";
	}
	
	
	public List<Fattura> richiestaListaFatture(){
		
		Response response = invocazione.richiestaListaFatture()
				                      .invoke();
		listaFatture = response.readEntity(new GenericType<List<Fattura>>(){});
		return listaFatture;
	}
	
	public List<Fattura> richiestaFattureDiUnPeriodo(FiltroFattura filtroF){
		
		Response response= invocazione.richiestaFattureDiUnPeriodo(filtroF.getDataInizio(), filtroF.getDataFine())
				   .invoke();
		
		listaFatture= response.readEntity(new GenericType<List<Fattura>>(){});
		return listaFatture;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<Fattura> getListaFatture() {
		return listaFatture;
	}

	public void setListaFatture(List<Fattura> listaFatture) {
		this.listaFatture = listaFatture;
	}

	public Fattura getFattura() {
		return fattura;
	}

	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}

	
}
