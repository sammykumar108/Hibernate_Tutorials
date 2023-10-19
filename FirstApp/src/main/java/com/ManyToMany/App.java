package com.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);

		Emp e1 = new Emp();
		e1.setId(101);
		e1.setName("Pavy");

		Emp e2 = new Emp();
		e2.setId(102);
		e2.setName("Rakesh");

		Address ad1 = new Address();
		ad1.setId(201);
		ad1.setAddressName("Delhi");

		Address ad2 = new Address();
		ad2.setId(202);
		ad2.setAddressName("Pune");

		List<Address> addList = new ArrayList<Address>();
		addList.add(ad1);
		addList.add(ad2);

		List<Emp> empList = new ArrayList<Emp>();
		empList.add(e1);
		empList.add(e2);

		e1.setAddress(addList);
		ad1.setEmp(empList);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

//		session.save(e1);
//		session.save(e2);
//		session.save(ad1);
//		session.save(ad2);
//		
//		System.out.println("Register Successfully");

		Emp emp = (Emp) session.get(Emp.class, 101);
		
		System.out.println(emp.getName());
		System.out.println(emp.getAddress().size());
		
		
		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
