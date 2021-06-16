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

/*
	Here in line 1 query is raised for the first time, So the application hits the database and fetches the required result
	In the line 2 the same query is raised again, so the application won't interact with database and retrieves the result from cache memory which is stored when
	line 1 query got executed
*/
