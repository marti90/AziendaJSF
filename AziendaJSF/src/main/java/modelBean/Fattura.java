package modelBean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean(name="f", eager=true)
@SessionScoped
@XmlRootElement
public class Fattura {
	
	private String codFattura;
	private Date dataEmissione;
	private double importo;
	
	public Fattura(){
		
	}
	
	public Fattura(String codFattura, Date dataEmissione, double importo) {
		super();
		this.codFattura = codFattura;
		this.dataEmissione = dataEmissione;
		this.importo = importo;
	}
	
	public String getCodFattura() {
		return codFattura;
	}
	
	public void setCodFattura(String codFattura) {
		this.codFattura = codFattura;
	}
	
	public Date getDataEmissione() {
		return dataEmissione;
	}
	
	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	
	public double getImporto() {
		return importo;
	}
	
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
}
