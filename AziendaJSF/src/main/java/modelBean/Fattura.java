package modelBean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean(name="f", eager=true)
@SessionScoped
@XmlRootElement
public class Fattura {
	
	private String codiceFattura;
	private Date data;
	private double importo;
	
	public Fattura(){
		
	}
	
	public Fattura(Date data, double importo, String codiceFattura) {

		this.codiceFattura = codiceFattura;
		this.data = data;
		this.importo = importo;
	}
	
	public String getCodFattura() {
		return codiceFattura;
	}
	
	public void setCodFattura(String codFattura) {
		this.codiceFattura = codFattura;
	}
	
	public Date getDataEmissione() {
		return data;
	}
	
	public void setDataEmissione(Date data) {
		this.data = data;
	}
	
	public double getImporto() {
		return importo;
	}
	
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
}
