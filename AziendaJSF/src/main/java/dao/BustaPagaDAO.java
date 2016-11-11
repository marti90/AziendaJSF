package dao;

import java.util.ArrayList;
import java.util.List;

import modelBean.BustaPaga;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class BustaPagaDAO {
	
	//1- CREATE
		public boolean createBustaPaga(BustaPaga bp){
				
			boolean res = false;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
					
				session.persist(bp);
				
				tx.commit();
				res= true;
				
			}catch(Exception ex){
				tx.rollback();
					
			}finally{
				session.close();
					
			}
				
			return res;
		}
		
		//2.a- READ con id
		public BustaPaga readBustaPaga(long id_busta){
			
			BustaPaga bp = null;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				bp = session.get(BustaPaga.class, id_busta);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return bp;
		}
		
		//2.c READ tutte le buste paga
		@SuppressWarnings("unchecked")
		public List<BustaPaga> readBustePaga(){
			
			List<BustaPaga> bustePaga = new ArrayList<BustaPaga>();
			Session session=HibernateUtility.openSession();
			Transaction tx=null;
			
			try{
		        tx=session.getTransaction();
		        tx.begin();
		        
		        Query query = session.createQuery("from BustaPaga");
		        bustePaga= query.list();
		        
		        tx.commit(); 
	            
		    }catch(Exception ex){
		         tx.rollback();

		    }finally{
		         session.close();
		    }
		    
			return bustePaga;
			
		}
		
		//2.c READ tutte le buste paga di un dipendente
			@SuppressWarnings("unchecked")
			public List<BustaPaga> readBustePagaDipendente(long id_dipendente){
					
				List<BustaPaga> bustePaga = new ArrayList<BustaPaga>();
				Session session=HibernateUtility.openSession();
				Transaction tx=null;
					
	    		try{
			        tx=session.getTransaction();
	    	        tx.begin();
				        
			        Query query = session.createQuery("from BustaPaga where Dipendente_Id_Dipendente=:idInserito");
			        query.setLong("idInserito", id_dipendente);
			        bustePaga= query.list();
				        
			        tx.commit(); 
			            
			    }catch(Exception ex){
			         tx.rollback();

			    }finally{
			         session.close();
			    }
				    
					return bustePaga;
					
			}
		
		//3- UPDATE
		public boolean updateBustaPaga(BustaPaga bp){

			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.update(bp);
				
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
		public boolean deleteBustaPaga(BustaPaga bp){
	        
			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.delete(bp);
				
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
