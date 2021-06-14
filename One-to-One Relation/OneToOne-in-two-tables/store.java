package com.practice.DemoHib;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;                 
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder; 

public class Store {
	public static void main(String[] args)
	{            
		Employee emp = new Employee();
		Address A = new Address();

		A.setColony("Colony A");
		A.setLandmark("Bakery"); 
		A.setLane(2); 
		A.setWard("Wahington");
		
		
		emp.setId(103);
		emp.setName("Thor");
		emp.setAddress(A);
		
		A.setEmployee(emp);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();    
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(emp);
		session.save(A);
		tx.commit();
		
	}
}
