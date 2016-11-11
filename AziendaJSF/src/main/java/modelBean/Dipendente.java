package modelBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@ManagedBean(name="d", eager=true)
@SessionScoped
@Entity
public class Dipendente extends Utente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double stipendio;
	private String posizione;
	
	@OneToMany(mappedBy="dipendente", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<BustaPaga> bustePaga = new ArrayList<BustaPaga>();
	
	public Dipendente(){
		super();
	}

	public Dipendente(String nome, String cognome, String username, char ruolo, String password, double stipendio, String posizione) {
		super(nome,cognome,username,ruolo,password);
		this.stipendio = stipendio;
		this.posizione = posizione;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public List<BustaPaga> getBustePaga() {
		return bustePaga;
	}

	public void setBustePaga(List<BustaPaga> bustePaga) {
		this.bustePaga = bustePaga;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void aggiungiBusta(BustaPaga bp){
		bustePaga.add(bp);
	}

	public boolean isValid() {

		boolean res=false;
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				!posizione.isEmpty() && posizione!=null) {
			
			res=true;
		}
		
		return res;
}
	
}
