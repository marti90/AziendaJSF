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
	
	public Invocation richiestaFattureDiUnPeriodo(String data1, String data2){
		
		return targetFatture.path("/periodo")
				            .queryParam("dataI", data1)
				            .queryParam("dataF", data2)
				            .request()
				            .buildGet();
	}
    

}
