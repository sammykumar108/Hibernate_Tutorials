package com.onetoMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Address ad1 = new Address(101, "Permanent Address", "Delhi");
		Address ad2 = new Address(102, "Office  Address", "Banglore");

		List<Address> list = new ArrayList<>();
		list.add(ad1);
		list.add(ad2);

		EmpDtls emp = new EmpDtls();
		emp.setId(202);
		emp.setName("Pavy Kumar");
		emp.setAddress(list);

		ad1.setEmpDtls(emp);
		ad2.setEmpDtls(emp);
		
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
//		session.save(emp);
//		session.save(ad1);
//		session.save(ad2);
		
		EmpDtls empx = session.get(EmpDtls.class, 202);
		
		session.delete(empx);
		
		
//		session.save(ad1);
//		session.save(ad2);
//		session.save(emp);
//		System.out.println("Insert successfully");

		
		/*
		 * EmpDtls empDtls = (EmpDtls) session.get(EmpDtls.class, 201);
		 * 
		 * System.out.println("Emp Name=" +empDtls.getName());
		 * 
		 * for(Address ad:empDtls.getAddress()) { System.out.println("Address Type=" +
		 * ad.getAddressType()+ ",address=" + ad.getAddress());
		 * 
		 * }
		 */
		 
		
//		Address ad=(Address)session.get(Address.class, 101);
//		System.out.println("Emp Name=" +ad.getEmpDtls().getName());
//		System.out.println(ad.getAddressType() + "," + ad.getAddress());
		tx.commit();
		session.close();
		factory.close();

	}
}
