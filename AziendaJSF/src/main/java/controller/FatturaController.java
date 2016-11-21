package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import modelBean.Fattura;
import client.InvocazioneFatture;

@ManagedBean(name="fatturaController",eager=true)
@SessionScoped
public class FatturaController {
	
	private InvocazioneFatture invocazione;
	private String codice;
	
	public FatturaController(){
		invocazione= new InvocazioneFatture();
	}
	
	public Fattura richiestaFatturaConCodice(String codice){
		
		System.out.println("Entrato");
		Response response = invocazione.richiestaFatturaConCodice(codice)
                                       .invoke();
		Fattura f= response.readEntity(Fattura.class);
		System.out.println(f.getCodiceFattura());
        return f;
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
		List<Fattura> listaFatture = response.readEntity(new GenericType<List<Fattura>>(){});
		return listaFatture;
	}
	
	public String richiestaFatturaConAnnoMese(String anno, String mese){
		
		invocazione.richiestaFatturaConAnnoMese(anno, mese)
				   .invoke();
		return "paginaViewFattura?faces-redirect=true";
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
