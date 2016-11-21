package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import modelBean.Fattura;

abstract class Invocazione {
	
	protected Client cliente = ClientBuilder.newClient();
	protected  WebTarget basedTarget = cliente.target("http://localhost:8085/WebServiceProgetto/alfasoft");
	protected WebTarget targetFatture = basedTarget.path("/fatture");
	
	abstract Invocation richiestaFatturaConCodice(String codFattura);
	
	abstract Invocation registraFattura(Fattura f);
	
	abstract Invocation richiestaListaFatture();
	
	abstract Invocation richiestaFattureDiUnPeriodo(String data1, String data2);
		
		

}
