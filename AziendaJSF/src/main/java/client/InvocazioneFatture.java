package client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;

import modelBean.Fattura;

public class InvocazioneFatture extends Invocazione{
	
	public InvocazioneFatture(){
		
	}
	
    public Invocation richiestaFatturaConCodice(String codFattura){
		
		return targetFatture.path(codFattura).request().buildGet();
	}

	public Invocation registraFattura(Fattura f){
		
		return targetFatture.request().buildPost(Entity.json(f));
	}
	
	public Invocation richiestaListaFatture(){
		
		return targetFatture.request().buildGet();
	}
	
	public Invocation richiestaFattureDiUnPeriodo(String dataInizio, String dataFine){
		
		return targetFatture.queryParam("dataInizio", dataInizio)
				            .queryParam("dataFine", dataFine)
				            .request()
				            .buildGet();
	}
    

}
