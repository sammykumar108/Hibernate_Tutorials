package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.becoder.HibernateUtil;
import com.becoder.Student;

public class App {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
//		Query q = session.createQuery("from Student");
		
		Criteria cr=session.createCriteria(Student.class);
		
//		cr.add(Restrictions.gt("salary", 50000));
//		cr.add(Restrictions.lt("salary",50000 ));
//		cr.add(Restrictions.like("name","A%" ));
//		cr.add(Restrictions.between("salary",40000 ,50000 ));
//		cr.add(Restrictions.isNull("salary"));
//		cr.add(Restrictions.isNotNull("name"));
		cr.add(Restrictions.eq("address", "INDIA"));
		
		List<Student> list = cr.list();
		
//		List<Student> list = q.list();
		
		for(Student s : list)
		{
			System.out.println(s);
		}
		
		
		
		factory.close();
	}
	
}
