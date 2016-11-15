package edit;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelBean.Cliente;

import org.primefaces.event.RowEditEvent;

import service.Gestione;
 
@ManagedBean(name="editCliente", eager=true)
@ViewScoped
public class EditCliente implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clienti;
	private Gestione g;
    
	public EditCliente(){
		
	}
	
    @PostConstruct
    public void init() {
    	g = new Gestione();
        clienti = g.getTuttiClienti();
    }
 
    public List<Cliente> getClienti() {
        return clienti;
    }
    
    public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
    }
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cliente Edited", ((Cliente) event.getObject()).getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        g.modificaCliente((Cliente) event.getObject());
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Cliente) event.getObject()).getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
	public Gestione getG() {
		return g;
	}

	public void setS(Gestione g) {
		this.g = g;
	}

	
	public String delete(Cliente c){
		g.eliminaCliente(c);
		return "elencoClienti";
	}
    
}
