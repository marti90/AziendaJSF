package modelBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;

@ManagedBean(name="a", eager=true)
@SessionScoped
@Entity
public class Admin extends Utente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String livelloAccesso;
	
	public Admin(){
		
	}

	public Admin(String nome, String cognome, String username, char ruolo, String password, String livelloAccesso) {
		super(nome,cognome,username,ruolo,password);
		this.setLivelloAccesso(livelloAccesso);
	}

	public String getLivelloAccesso() {
		return livelloAccesso;
	}

	public void setLivelloAccesso(String livelloAccesso) {
		this.livelloAccesso = livelloAccesso;
	}
	
	public boolean isValid() {
		
		boolean res=false;
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				!livelloAccesso.isEmpty() && livelloAccesso!=null) {
			
			res=true;
		}
		
		return res;
}
	

}
