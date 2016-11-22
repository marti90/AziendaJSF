package server;

import dao.BustaPaga2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelBean.BustaPagaService;

@Path("bustePaga")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class RisorsaBustaPaga {
	
	BustaPaga2DAO bDao= new BustaPaga2DAO();
	
	@GET
	public List<BustaPagaService> getTutteBuste(){
		return new ArrayList<BustaPagaService>(bDao.readBustePaga2());
	}
	
}
