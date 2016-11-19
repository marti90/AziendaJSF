package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import modelBean.Cliente;
import modelBean.Fattura;
import client.Invocazione;

@ManagedBean(name="fatturaController",eager=true)
@SessionScoped
public class FatturaController {
	
	Invocazione invocazione = new Invocazione();
	
	public Fattura richiestaFatturaConCodice(String codice){
		
		Response risposta = invocazione.richiestaFatturaConCodice(codice)
                                       .invoke();

        Fattura fattura = risposta.readEntity(Fattura.class);
        return fattura;
	}
	
	public String inviaFattura(Fattura f){
		
		Response response = invocazione.registraFattura(f)
				                       .invoke();
		
		if(response.getStatus()!=201){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La Fattura e' stata inviata correttamente!"));
		}
		
		return "HomePageAdmin?faces-redirect=true";
	}
	
	
	public List<Fattura> richiestaListaFatture(){
		
		Response response= invocazione.richiestaListaFatture()
				                      .invoke();
		List<Fattura> listaFatture = response.readEntity(new GenericType<List<Fattura>>(){});
		return listaFatture;
	}

}
