package com.prog;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session session = factory.openSession();
    	
    	//Student save - Create
		
		
		  Student st=new Student(); st.setName("Sammy"); st.setAddress("India");
		  st.setEmail("sammy@gmail.com"); st.setCollegeName("UK University");
		  
		  Student st2=new Student(); st2.setName("Rahul"); st2.setAddress("Pakistan");
		  st2.setEmail("rahul@gmail.com"); st2.setCollegeName("Rusia University");
		  
		  Transaction tx = session.beginTransaction(); session.save(st);
		  session.save(st2); tx.commit();
		  System.out.println("Student Register Successfully");
		  
		 
    	
    	// read data
		
		  List<Student> list =
		  session.createQuery("from Student",Student.class).list();
		  
		  list.forEach(e-> System.out.println(e));
		 
    	
    	// get by id
		/*
		 * Student st = session.get(Student.class, 1); System.out.println(st);
		 */
    	
    	//update data
		/*
		 * Student st = session.get(Student.class, 1); st.setName("Sammy update");
		 * st.setAddress("India update"); st.setEmail("sammy@gmail.com update");
		 * st.setCollegeName("UK University update");
		 * 
		 * Transaction tx = session.beginTransaction();
		 * 
		 * session.saveOrUpdate(st);
		 * 
		 * tx.commit(); System.out.println("Data updated succeessfully");
		 */
    	
    	// delete data
		/*
		 * Student st = session.get(Student.class, 1);
		 * 
		 * Transaction tx = session.beginTransaction(); session.delete(st); tx.commit();
		 * System.out.println("Data Deleted succeessfully");
		 */
    	
    	
    	session.close();  
    	factory.close();    	
    	
    }
}
