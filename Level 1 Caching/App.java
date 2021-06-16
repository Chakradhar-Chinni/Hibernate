package com.telusko.relations;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;                  
import org.hibernate.cfg.Configuration;  
public class App 
{
	public static void main(String[] args)
	{
		Student s = null;
		  
		    Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Session session2 = sf.openSession();                 
        
        session1.beginTransaction();
        	s = (Student) session1.get(Student.class,20);  //line 1
        	//.get returns object method so we type cast it to class name(Student)
        	System.out.println(s);
    
        	s = (Student) session1.get(Student.class,20);   //line 2
        	System.out.println(s);
        	
        session1.getTransaction().commit();
        
	}
}
