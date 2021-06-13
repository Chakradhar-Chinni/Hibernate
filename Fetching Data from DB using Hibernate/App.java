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
        
    	  Alien telusko = null;
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        telusko = (Alien)session.get(Alien.class, 102);    //get method returns object type, so it is type casted to Alien (POJO class name)     
        tx.commit();
        
        System.out.println(telusko);
    }
}
