package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


import folder.satici;
import folder.siparis;

import folder.urun;



public class test {
	static EntityManagerFactory factory;
	static EntityManager manager;
	
	
	
	
	void ekle(){
		factory = Persistence.createEntityManagerFactory("fonksiyonluJPA");
		manager = factory.createEntityManager();
		
		
		
		
		
		
		
		/*try {
			manager.getTransaction().begin();
			
			satici sat =new satici();
			sat.set›sim("qfe");
			sat.setSifre("12342");
			sat.setOrders(null);
			
			
			
			
			manager.persist(sat);
			
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		}/*finally {
			manager.close();
			factory.close();
		}
		*/
		
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory("fonksiyonluJPA");
		manager = factory.createEntityManager();
		
		
		
		/*	
		    
			try
			{
				
				manager.getTransaction().begin();
				
				
			 /*   Query query = manager.createQuery( "SELECT e FROM satici e where e.isim='erdd'" );
			      
			      List<satici> list=(List<satici>)query.getResultList( );

			      for( satici e:list ){
			         System.out.print("Employee ID :" + e.get›d());
			         System.out.println("\t Employee salary :" + e.getSoy›sim());
			      }
				
			*/	
			
			//satici sat1 =manager.find(satici.class, (long)1);
			
			
			//String sql = "select * from satici where kulAdi=erdd";
			
			
			// satici listLogin= new satici();
			// listLogin=manager.createNamedQuery(sql,satici.class);
				
			
			//System.out.println(listLogin.get›d()+listLogin.get›sim()+listLogin.getSoy›sim());
			//satici sat2 =manager.fi
			
			//System.out.println(sat1.get›sim());
		/*   
			manager.getTransaction().commit();
			
			
			}catch(Exception e) {
				e.printStackTrace();
							manager.getTransaction().rollback();

				
				
				
			}
		    	*/
		
		
			//manager.close();
			//factory.close();
		
		/*test satici =new test();
		
		satici.ekle();*/
		
		
		try {
			manager.getTransaction().begin();
			
			
			  
			satici sat =new satici();
			sat.set›sim("remzi");
			sat.setSifre("kalpak");
			satici sat1 =new satici();
			sat1.set›sim("hamdi");
			sat1.setSifre("parlak");
			satici sat2 =new satici();
			sat2.set›sim("erdd");
			sat2.setSifre("qwrqwdqlak");
			
			
			urun u1 = new urun();
			u1.set›smi("kola");
			u1.setFiyati(2.15);
			manager.persist(u1);
			
			urun u2 = new urun();
			u2.set›smi("su");
			u2.setFiyati(1.0);
			manager.persist(u2);
			
			urun u3 = new urun();
			u3.set›smi("Áay");
			u3.setFiyati(1.25);
			manager.persist(u3);
		
			siparis sip1 = new siparis();
			siparis sip2 = new siparis();
			siparis sip3 = new siparis();
			
			sip1.setMusAdi("masdma");
			sip1.setTutar(15);
			sip1.setCustomer(sat);
			
			
			sip2.setMusAdi("asrntr");
			sip2.setTutar(13);
			sip2.setCustomer(sat);
			
			sip3.setMusAdi("eafa");
			sip3.setTutar(14);
			sip3.setCustomer(sat1);
			/*
			sat.getOrders().add(sip1);
			sat.getOrders().add(sip2);
			
			sat1.getOrders().add(sip3);
			sat1.getOrders().add(sip1);
			*/
			
			sip1.setCustomer(sat);
			sip2.setCustomer(sat);
			sip3.setCustomer(sat2);
			
			
			
			
			
			u1.getSiparis().add(sip1);
			u2.getSiparis().add(sip1);
			
			u3.getSiparis().add(sip2);
			u1.getSiparis().add(sip2);
		
			sip1.getUrun().add(u1);
			sip1.getUrun().add(u2);
			
			sip2.getUrun().add(u3);
			sip2.getUrun().add(u1);
			
			//siparis_urun s = new siparis_urun();
			//manager.persist(s);
			
			manager.persist(sat);
			manager.persist(sat1);
			manager.persist(sat2);
			
			manager.persist(u1);
			manager.persist(u2);
			manager.persist(u3);
		
	
			
			manager.persist(sip1);
			manager.persist(sip2);
			manager.persist(sip3);
			
			
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//manager.getTransaction().rollback();
		}
		
	}

}
