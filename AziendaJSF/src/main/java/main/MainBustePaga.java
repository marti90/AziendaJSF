package main;

import service.Gestione;
import modelBean.BustaPaga;
import modelBean.Dipendente;

public class MainBustePaga {

	public static void main(String[] args) {
		
		Dipendente d1 = new Dipendente("Martina", "DeMartini","marti90",'D',"ml90",10500.5,"Posizione");
		Dipendente d2 = new Dipendente("Rossella", "Pillotta","ross",'D',"magliaAzzurra",10500.5,"Posizione");
		
		BustaPaga b1 = new BustaPaga(d1,"20/11/2016",200.6);
		BustaPaga b2 = new BustaPaga(d2,"21/11/2016",205.6);
		BustaPaga b3 = new BustaPaga(d2,"18/11/2016",10.6);
		BustaPaga b4 = new BustaPaga(d1,"19/11/2016",400.6);
		
		Gestione g = new Gestione();
		
		g.registraDipendente(d1);
		g.registraDipendente(d2);
		
		g.registraBusta(d1, b1);
		g.registraBusta(d2, b2);
		g.registraBusta(d2, b3);
		g.registraBusta(d1, b4);

	}

}
