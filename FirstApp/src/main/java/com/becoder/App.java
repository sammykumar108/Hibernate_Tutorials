package com.becoder;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
		/*
		 * Configuration cfg=new Configuration(); cfg.configure("hibernate.xml");
		 * 
		 * SessionFactory factory = cfg.buildSessionFactory();
		 */
        
//        SessionFactory factory = new Configuration().configure("hibernate.xml").buildSessionFactory();
//        System.out.println(factory);

        SessionFactory factory=HibernateUtil.getSessionFactory();
//      System.out.println(factory);        
        
		/*
		 * Student st=new Student(); st.setId(1); st.setName("Becoder");
		 * st.setEmail("becoder@gmail.com"); st.setAddress("India"); Session session =
		 * factory.openSession(); Transaction tx = session.beginTransaction();
		 * 
		 * session.save(st);
		 * 
		 * tx.commit();
		 * 
		 * session.close();
		 */
        
        Employee emp=new Employee();
        emp.setEmpName("Prem Kumar2");
        emp.setEmail("prem2@gmail.com");
        emp.setSalary(400000.00);
        emp.setJoiningDate(new Date());
        emp.setStatus(true);
        emp.setToken("hdjfd111");
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(emp);        
        transaction.commit();
        session.close();
        
    }
}

























