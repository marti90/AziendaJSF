package server;

import dao.BustaPagaDAO;
import modelBean.BustaPaga;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RisorsaBustaPaga {
	
	BustaPagaDAO bDao= new BustaPagaDAO();
	
	@GET
	public List<BustaPaga> getTutteBuste(){
		return new ArrayList<BustaPaga>(bDao.readBustePaga());
	}
	
}
