package com.relationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppMain {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Address ad=new Address();
		ad.setId(101);
		ad.setAddress("Odisha");
		
		EmpDtls e=new EmpDtls();
		e.setId(201);
		e.setName("Pavy");
		e.setAddress(ad);
		
		ad.setEmp(e);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();		
//		session.save(ad);
//		session.save(e);		

//		EmpDtls emp = session.get(EmpDtls.class,201 );
//		System.out.println(emp.getName());
//		System.out.println(emp.getAddress().getAddress());
	
		Address na = (Address)session.get(Address.class, 101);
		System.out.println(na.getAddress());
		System.out.println(na.getEmp().getName());
		
		
		transaction.commit();
		session.close();
		
		
		//System.out.println("Insert successfully");
		factory.close();
		
		
		
	}
}
