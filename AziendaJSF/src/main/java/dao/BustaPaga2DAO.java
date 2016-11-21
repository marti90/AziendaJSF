package dao;

import java.util.ArrayList;
import java.util.List;

import modelBean.BustaPagaService;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class BustaPaga2DAO {
	
	//1- CREATE
			public boolean createBustaPaga2(BustaPagaService bp2){
					
				boolean res = false;
					
				Session session = HibernateUtility.openSession();
				Transaction tx = null;
					
				try{
					tx = session.getTransaction();
					tx.begin();
						
					session.persist(bp2);
					
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
			public BustaPagaService readBustaPaga2(long id_busta){
				
				BustaPagaService bp2 = null;
				
				Session session = HibernateUtility.openSession();
				Transaction tx = null;
				
				try{
					tx = session.getTransaction();
					tx.begin();
					
					bp2 = session.get(BustaPagaService.class, id_busta);
					
					tx.commit();
					
				}catch(Exception ex){
					tx.rollback();
					
				}finally{
					session.close();
					
				}
				
				return bp2;
			}
			
			//2.c READ tutte le buste paga
			@SuppressWarnings("unchecked")
			public List<BustaPagaService> readBustePaga2(){
				
				List<BustaPagaService> bustePaga = new ArrayList<BustaPagaService>();
				Session session=HibernateUtility.openSession();
				Transaction tx=null;
				
				try{
			        tx=session.getTransaction();
			        tx.begin();
			        
			        Query query = session.createQuery("from BustaPagaService");
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
			public boolean updateBustaPaga2(BustaPagaService bp2){

				boolean res = false;
				
				Session session = HibernateUtility.openSession();
				Transaction tx = null;
				
				try{
					tx = session.getTransaction();
					tx.begin();
					
					session.update(bp2);
					
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
			public boolean deleteBustaPaga2(BustaPagaService bp2){
		        
				boolean res = false;
				
				Session session = HibernateUtility.openSession();
				Transaction tx = null;
				
				try{
					tx = session.getTransaction();
					tx.begin();
					
					session.delete(bp2);
					
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
