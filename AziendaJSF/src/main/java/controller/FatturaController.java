package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import modelBean.Fattura;
import client.InvocazioneFatture;

@ManagedBean(name="fatturaController",eager=true)
@ViewScoped
public class FatturaController {
	
	private InvocazioneFatture invocazione;
	private List<Fattura> listaFatture;
	private List<Fattura> listaFatture2;
	
	private String codice;
	private Fattura fattura;
	
	public FatturaController(){
		invocazione= new InvocazioneFatture();
		setListaFatture(new ArrayList<Fattura>());
		setListaFatture2(new ArrayList<Fattura>());
	}
	
	public Fattura richiestaFatturaConCodice(String codice){
		
		System.out.println("Entrato");
		Response response = invocazione.richiestaFatturaConCodice(codice)
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
	
	public List<Fattura> richiestaFattureDiUnPeriodo(@QueryParam("dataInizio")Date dataInizio,
			                                         @QueryParam("dataFine") Date dataFine){
		
		DateFormat df = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String data_Inizio = df.format(dataInizio);
		String data_Fine = df.format(dataFine);
				
		Response response= invocazione.richiestaFattureDiUnPeriodo(data_Inizio, data_Fine)
				   .invoke();
		
		listaFatture2= response.readEntity(new GenericType<List<Fattura>>(){});
		return listaFatture2;
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

	public List<Fattura> getListaFatture2() {
		return listaFatture2;
	}

	public void setListaFatture2(List<Fattura> listaFatture2) {
		this.listaFatture2 = listaFatture2;
	}
	
}
