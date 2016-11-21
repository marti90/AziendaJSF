package modelBean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@ManagedBean(name="busta2", eager=true)
@XmlRootElement
public class BustaPagaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_busta;
	
	private String codiceBusta;
	private Date data;
	private double importo;
	
    public BustaPagaService(){
		
	}

	public BustaPagaService(String codiceBusta, Date data, double importo) {
		
		this.codiceBusta = codiceBusta;
		this.data = data;
		this.importo = importo;
	}

	public long getId_busta() {
		return id_busta;
	}

	public void setId_busta(long id_busta) {
		this.id_busta = id_busta;
	}

	public String getCodiceBusta() {
		return codiceBusta;
	}

	public void setCodiceBusta(String codiceBusta) {
		this.codiceBusta = codiceBusta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
