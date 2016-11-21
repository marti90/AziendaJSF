package modelBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;

@ManagedBean(name="c", eager=true)
@RequestScoped
@Entity
public class Cliente extends Utente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ragioneSociale;
	private String pIva;
	
	public Cliente(){
		
	}
	
	public Cliente(String nome, String cognome, String username, char ruolo, String password, String ragioneSociale, String pIva) {
		super(nome,cognome,username,ruolo,password);
		this.ragioneSociale = ragioneSociale;
		this.pIva = pIva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
	
	public boolean isValid() {

		boolean res=false;
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				!ragioneSociale.isEmpty() && ragioneSociale!=null &&
				!pIva.isEmpty() && pIva!=null) {
			
			res=true;
		}
		
		return res;
	}

	
}
