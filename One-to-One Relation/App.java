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

    	Student s = new Student();
    	laptop l = new laptop();
    	

    	l.setLid(10);
    	l.setLname("HP");
    	
    	s.setRollno(1);
    	s.setName("Serjio");
    	s.setMarks(100);
    	s.setL(l);
    	
    
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        
        
        Transaction tx = session.beginTransaction();        
        
        session.save(s);
        session.save(l);
        
        tx.commit();  // (or) session.beginTransaction().commit();
    }
}
