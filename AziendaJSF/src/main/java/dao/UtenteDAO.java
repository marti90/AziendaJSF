package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelBean.Utente;
import utility.HibernateUtility;


public class UtenteDAO {
	
	//1- CREATE
	public boolean createUtente(Utente u){
			
		boolean res = false;
			
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			session.persist(u);
			
			tx.commit();
			res= true;
			
		}catch(Exception ex){
			tx.rollback();
				
		}finally{
			session.close();
				
		}
			
		return res;
	}
	
	//2.a- READ con username
	public Utente readUtente(String username){
			
		Utente u = null;
			
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
			
			Query query=session.createQuery("from Utente where username=:usernameInserito");
			query.setString("usernameInserito", username);
	        u=(Utente) query.uniqueResult();
				
			tx.commit();
				
		}catch(Exception ex){
			tx.rollback();
				
		}finally{
				session.close();
				
		}
		
		return u;
	}
		
	//2.a- READ con id
	public Utente readUtente(long id_utente){
		
		Utente u = null;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			u = session.get(Utente.class, id_utente);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return u;
	}
	
	//2.b- READ con username e password
	public Utente readUtente(String username, String password){
		
		Utente u = null;
		
		Session session = HibernateUtility.openSession();
        Transaction tx = null;
        Query query = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			query = session.createQuery("from Utente where username =:usernameInserito and password =:passwordInserita");
			query.setString("usernameInserito", username);
			query.setString("passwordInserita", password);
			u = (Utente) query.uniqueResult();
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return u;
	}
	
	//2.c READ tutti gli utenti della tabella
	@SuppressWarnings("unchecked")
	public List<Utente> readUtenti(){
		
		List<Utente> utenti = new ArrayList<Utente>();
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        Query query = session.createQuery("from Utente");
	        utenti= query.list();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return utenti;
		
	}
	
	//3- UPDATE
	public boolean updateUtente(Utente u){

		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.update(u);
			
			tx.commit();
			res= true;
			
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}
	
	//4- DELETE
	public boolean deleteUtente(Utente u){
        
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.delete(u);
			
			tx.commit();
			res= true;
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}

}
