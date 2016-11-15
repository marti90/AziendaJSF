package edit;
	
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelBean.Dipendente;
import org.primefaces.event.RowEditEvent;

import service.Gestione;
	 
	@ManagedBean(name="editDipendente", eager=true)
	@ViewScoped
	public class EditDipendente implements Serializable {
	     
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private List<Dipendente> dipendenti;
		private Gestione g;
	    
		public EditDipendente(){
			
		}
		
	    @PostConstruct
	    public void init() {
	    	g = new Gestione();
	        dipendenti = g.getTuttiDipendenti();
	    }
	 
	    public List<Dipendente> getDipendenti() {
	        return dipendenti;
	    }
	    
	    public void setDipendenti(List<Dipendente> dipendenti) {
			this.dipendenti = dipendenti;
	    }
	    
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
	    public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Dipendente Edited", ((Dipendente) event.getObject()).getUsername());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        g.modificaDipendente((Dipendente) event.getObject());
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Dipendente) event.getObject()).getUsername());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
		public Gestione getG() {
			return g;
		}

		public void setS(Gestione g) {
			this.g = g;
		}

		
		public String delete(Dipendente d){
			g.eliminaDipendente(d);
			return "elencoDipendenti";
		}
	    

}
