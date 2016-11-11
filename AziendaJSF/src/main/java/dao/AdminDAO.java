package dao;

import java.util.ArrayList;
import java.util.List;

import modelBean.Admin;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

    public class AdminDAO {
	
	//1- CREATE
		public boolean createAdmin(Admin a){
				
			boolean res = false;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
					
				session.persist(a);
				
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
		public Admin readAdmin(String username){
				
			Admin a = null;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
				
				Query query=session.createQuery("from Utente where username=:usernameInserito");
				query.setString("usernameInserito", username);
				a=(Admin) query.uniqueResult();
					
				tx.commit();
					
			}catch(Exception ex){
				tx.rollback();
					
			}finally{
					session.close();
					
			}
			
			return a;
		}
			
		//2.a- READ con id
		public Admin readAdmin(long id_utente){
			
			Admin a = null;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				a = session.get(Admin.class, id_utente);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return a;
		}
		
		//2.b- READ con username e password
		public Admin readUtente(String username, String password){
			
			Admin a = null;
			
			Session session = HibernateUtility.openSession();
	        Transaction tx = null;
	        Query query = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				query = session.createQuery("from Admin where username =:usernameInserito and password =:passwordInserita");
				query.setString("usernameInserito", username);
				query.setString("passwordInserita", password);
				a = (Admin) query.uniqueResult();
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return a;
		}
		
		//2.c READ tutti gli admin della tabella
	   
		@SuppressWarnings("unchecked")
		public List<Admin> readAdmin(){
			
			List<Admin> utenti = new ArrayList<Admin>();
			Session session=HibernateUtility.openSession();
			Transaction tx=null;
			
			try{
		        tx=session.getTransaction();
		        tx.begin();
		        
		        Query query = session.createQuery("from Admin");
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
		public boolean updateAdmin(Admin a){

			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.update(a);
				
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
		public boolean deleteAdmin(Admin a){
	        
			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.delete(a);
				
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
