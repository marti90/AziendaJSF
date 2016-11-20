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

		this.setCodiceFattura(codiceFattura);
		this.setData(data);
		this.importo = importo;
	}
	
	public double getImporto() {
		return importo;
	}
	
	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getCodiceFattura() {
		return codiceFattura;
	}

	public void setCodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
