package main;

import java.util.Date;

import service.GestioneBustaPaga;
import modelBean.BustaPagaService;

public class MainBustePaga {

	public static void main(String[] args) {
		
		Date d = new Date();
		
		BustaPagaService b1 = new BustaPagaService("busta1",d,200.6);
		BustaPagaService b2 = new BustaPagaService("busta2",d,205.6);
		BustaPagaService b3 = new BustaPagaService("busta3",d,10.6);
		BustaPagaService b4 = new BustaPagaService("busta4",d,400.6);
		
		GestioneBustaPaga gbp = new GestioneBustaPaga();
		
		gbp.registraBusta2(b1);
		gbp.registraBusta2(b2);
		gbp.registraBusta2(b3);
		gbp.registraBusta2(b4);

	}

}
