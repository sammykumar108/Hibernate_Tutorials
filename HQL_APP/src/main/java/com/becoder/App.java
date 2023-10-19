package com.becoder;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
//import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * SessionFactory factory = HibernateUtil.getSessionFactory(); //
		 * System.out.println(factory);
		 * 
		 * Student s1 = new Student(); s1.setName("Mohan"); s1.setAddress("China");
		 * 
		 * Student s2 = new Student(); s2.setName("Arun"); s2.setAddress("Bhutan");
		 * 
		 * Session session = factory.openSession();
		 * 
		 * Transaction tx = session.beginTransaction(); session.save(s1);
		 * session.save(s2);
		 * 
		 * tx.commit();
		 */

//		Query q = session.createQuery("from Student order by id desc");
//		List<Student> list = q.list();
//
//		for (Student s : list) {
//			System.out.println(s);
//		}

//		System.out.println(session.get(Student.class, 1));
//		Query q = session.createQuery("from Student where id='1' and address='India'");

		// Dynamic value
		/*
		 * Query q =
		 * session.createQuery("from Student as s where s.id=:id and s.address=:ad ");
		 * q.setParameter("id", 2); q.setParameter("ad", "USA");
		 * System.out.println(q.uniqueResult());
		 */

//		System.out.println("Register Successfully");

//		Query q = session.createQuery("select address from  Student where id='2' and address='USA' ");
//		System.out.println(q.uniqueResult());

//		Query q = session.createQuery("Delete from Student where id='1' ");
//		int i=q.executeUpdate();
//		System.out.println(i +" Delete Successfully");

//		Query q = session.createQuery("update Student set address='INDIA' where id='2' ");
//		int i=q.executeUpdate();
//		System.out.println(i + " Update Successfully");

		// First level caching

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Student st = session.get(Student.class, 2);
		System.out.println(st);

//		Student st2 = session.get(Student.class, 2);
//		System.out.println(st2);

//		Student st3 = session.get(Student.class, 2);
//		System.out.println(st3);

		session.close();
		
//		Session session2 = factory.openSession();
//		Student st2 = session2.get(Student.class, 2);
//		System.out.println(st2);
//		session2.clear();
//		session2.close();
		factory.close();

	}
}
