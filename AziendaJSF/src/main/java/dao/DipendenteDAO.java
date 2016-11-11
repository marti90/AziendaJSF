package dao;

import java.util.ArrayList;
import java.util.List;

import modelBean.Dipendente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class DipendenteDAO {
	
	//1- CREATE
		public boolean createDipendente(Dipendente d){
				
			boolean res = false;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
					
				session.persist(d);
				
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
		public Dipendente readDipendente(String username){
				
			Dipendente d = null;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
				
				Query query=session.createQuery("from UtenteBean where username=:usernameInserito");
				query.setString("usernameInserito", username);
		        d=(Dipendente) query.uniqueResult();
					
				tx.commit();
					
			}catch(Exception ex){
				tx.rollback();
					
			}finally{
					session.close();
					
			}
			
			return d;
		}
			
		//2.a- READ con id
		public Dipendente readDipendente(long id_utente){
			
			Dipendente d = null;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				d = session.get(Dipendente.class, id_utente);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return d;
		}
		
		//2.b- READ con username e password
		public Dipendente readDipendente(String username, String password){
			
			Dipendente d = null;
			
			Session session = HibernateUtility.openSession();
	        Transaction tx = null;
	        Query query = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				query = session.createQuery("from Dipendente where username =:usernameInserito and password =:passwordInserita");
				query.setString("usernameInserito", username);
				query.setString("passwordInserita", password);
				d = (Dipendente) query.uniqueResult();
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return d;
		}
		
		//2.c READ tutti i dipendenti della tabella
	   
		@SuppressWarnings("unchecked")
		public List<Dipendente> readDipendenti(){
			
			List<Dipendente> dipendenti = new ArrayList<Dipendente>();
			Session session=HibernateUtility.openSession();
			Transaction tx=null;
			
			try{
		        tx=session.getTransaction();
		        tx.begin();
		        
		        Query query = session.createQuery("from Dipendente");
		        dipendenti= query.list();
		        
		        tx.commit(); 
	            
		    }catch(Exception ex){
		         tx.rollback();

		    }finally{
		         session.close();
		    }
		    
			return dipendenti;
			
		}
		
		//3- UPDATE
		public boolean updateDipendente(Dipendente d){

			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.update(d);
				
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
		public boolean deleteDipendente(Dipendente d){
	        
			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.delete(d);
				
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
