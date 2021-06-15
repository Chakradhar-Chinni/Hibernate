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
		Student student = new Student();
		Laptop laptop = new Laptop();
		
		laptop.setLid(2002);
		laptop.setLname("DELL");
		
		student.setMarks(100); 
		student.setName("Serjio");
		student.setRollno(1001);
		student.getLaptop().add(laptop);
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        
        
        Transaction tx = session.beginTransaction();        
        
	      session.save(student);
	      session.save(laptop);
        
        tx.commit();  // (or) session.beginTransaction().commit();
	}
}
