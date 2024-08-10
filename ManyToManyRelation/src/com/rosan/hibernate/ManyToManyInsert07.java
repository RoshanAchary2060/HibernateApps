package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToManyInsert07 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Student s = sess.get(Student.class, 506);
		Query qry = sess.createQuery("from Course");
		List<Course> list = qry.list();
		for (Course c : list) {
			s.getCourses().add(c);
		}
		Transaction tx = sess.beginTransaction();
		sess.save(s);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
