package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;
import modelRubrica.RubricaModel;
import modelRubrica.VoceModel;
public class VoceDAO {
	
	public boolean createVoce(VoceModel v){
		
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.persist(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
	public VoceModel readVoceConId(long id_voce){
		
		VoceModel v = null;
		
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       v=session.get(VoceModel.class,  id_voce);
		        
		       tx.commit(); 
		       
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return v;
	}
	
	public VoceModel readVoce(String nome, String cognome, long id_rubrica)
	{
		VoceModel v=null;
		Session session =HibernateUtility.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from VoceModel where RubricaModel_id_rubrica=:idInserito and nome=:nomeInserito and cognome=:cognomeInserito");
		query.setLong("idInserito", id_rubrica);
		query.setString("nomeInserito", nome);
		query.setString("cognomeInserito", cognome);
		v=(VoceModel) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return v;
    }
	
	public boolean aggiornaVoce(VoceModel v){
		
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.update(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
	public List<VoceModel> getVociPerUnaRubrica(String nome){
		
		RubricaModel r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        Query query = session.createQuery("from RubricaModel where nome =:nomeInserito");
	        query.setString("nomeInserito", nome);
	        r = (RubricaModel) query.uniqueResult();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r.getListaVoci();
		
	}
	
    public boolean deleteVoce(VoceModel v){
    	
    	boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.delete(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
    }

}
