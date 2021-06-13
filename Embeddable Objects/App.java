package com.telusko.DemoHib;  

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;                 
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder; 

public class App  
{
    public static void main( String[] args )
    { 

    	Alien telusko = new Alien();
    	
    	//Address is embedded into separate class as it contains multiple fields
    	Address info = new Address(); 
    	info.setHome("Colony A"); 
    	info.setOffice("Colony C");
    	info.setResidential("Colony B");

    	telusko.setAid(103); 
    	telusko.setAcolor("Green");
    	telusko.setAname("Arya");
    	telusko.setAddress(info);
    
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
     
        		
        session.save(telusko);
        
        tx.commit();
    }
}
