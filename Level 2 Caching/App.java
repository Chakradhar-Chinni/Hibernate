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
        
        session1.beginTransaction();
        	s = (Student) session1.get(Student.class,20);  //line 1
        	//.get returns object method so we type cast it to class name
        	System.out.println(s);
       	session1.getTransaction().commit();
       	session1.close();
       	
       	                 
     	 Session session2 = sf.openSession();
	     session2.beginTransaction();
	        	s = (Student) session2.get(Student.class,20);   //line 2
	        	System.out.println(s);
	     session2.getTransaction().commit();
	     session2.close();
        	
        
	}
}
/*
	-> Here, same query is used in different sessions, as Second Level cache is used here, though session1 is closed session2 is having the same query, now the application
	   don't interact with the Database, application retrieves the Data from second level cache
	
	
*/
