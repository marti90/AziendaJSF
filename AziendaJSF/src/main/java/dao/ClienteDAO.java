package dao;

import java.util.ArrayList;
import java.util.List;

import modelBean.Cliente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class ClienteDAO {
	
	//1- CREATE
		public boolean createCliente(Cliente c){
				
			boolean res = false;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
					
				session.persist(c);
				
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
		public Cliente readCliente(String username){
				
			Cliente c = null;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
				
				Query query=session.createQuery("from Utente where username=:usernameInserito");
				query.setString("usernameInserito", username);
				c=(Cliente) query.uniqueResult();
					
				tx.commit();
					
			}catch(Exception ex){
				tx.rollback();
					
			}finally{
					session.close();
					
			}
			
			return c;
		}
			
		//2.a- READ con id
		public Cliente readCliente(long id_utente){
			
			Cliente c = null;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				c = session.get(Cliente.class, id_utente);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return c;
		}
		
		//2.b- READ con username e password
		public Cliente readCliente(String username, String password){
			
			Cliente c = null;
			
			Session session = HibernateUtility.openSession();
	        Transaction tx = null;
	        Query query = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				query = session.createQuery("from Cliente where username =:usernameInserito and password =:passwordInserita");
				query.setString("usernameInserito", username);
				query.setString("passwordInserita", password);
				c = (Cliente) query.uniqueResult();
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return c;
		}
		
		//2.c READ tutti gli utenti della tabella
	   
		@SuppressWarnings("unchecked")
		public List<Cliente> readClienti(){
			
			List<Cliente> clienti = new ArrayList<Cliente>();
			Session session=HibernateUtility.openSession();
			Transaction tx=null;
			
			try{
		        tx=session.getTransaction();
		        tx.begin();
		        
		        Query query = session.createQuery("from Cliente");
		        clienti= query.list();
		        
		        tx.commit(); 
	            
		    }catch(Exception ex){
		         tx.rollback();

		    }finally{
		         session.close();
		    }
		    
			return clienti;
			
		}
		
		//3- UPDATE
		public boolean updateCliente(Cliente c){

			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.update(c);
				
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
		public boolean deleteCliente(Cliente c){
	        
			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.delete(c);
				
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
