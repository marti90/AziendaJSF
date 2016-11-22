package modelBean;

import javax.ws.rs.QueryParam;

public class FiltroFattura {
	
	private @QueryParam("dataInizio")String dataInizio;
	private @QueryParam("dataFine") String dataFine;
	
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getDataFine() {
		return dataFine;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	
	

}
