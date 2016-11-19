package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import modelBean.Fattura;

public class Invocazione {
	
	private Client cliente = ClientBuilder.newClient();
	private WebTarget basedTarget = cliente.target("http://localhost:8086/ServerFatture/alfasoft");
	private WebTarget targetFatture = basedTarget.path("/fatture");
	
	public Invocazione(){
		
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
		
		

}
