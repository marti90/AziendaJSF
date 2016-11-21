package service;

import java.util.List;

import modelBean.BustaPagaService;
import dao.BustaPaga2DAO;


public class GestioneBustaPaga {
	
	BustaPaga2DAO bDao2 = new BustaPaga2DAO();
	
    public boolean registraBusta2(BustaPagaService bp2) {
		
    	boolean res = false;
		boolean b = bDao2.createBustaPaga2(bp2);
		if(b==true)
		{
			res =true;
		}
		
		return res;
	}
    
    public BustaPagaService getBusta2ConId(long id_busta){
		
		BustaPagaService bp = bDao2.readBustaPaga2(id_busta);
		return bp;
	}
    
    public boolean eliminaBusta2(BustaPagaService bp2){
		
		return bDao2.deleteBustaPaga2(bp2);
	}

    public List<BustaPagaService> getTutteBuste2(){
		
		return bDao2.readBustePaga2();
	}
    
}
