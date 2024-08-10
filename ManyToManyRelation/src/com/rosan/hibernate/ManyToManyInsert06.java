package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyInsert06 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Student s = sess.get(Student.class, 504);
		Course c = sess.get(Course.class, 103);

		c.getStudents().add(s);

		Transaction tx = sess.beginTransaction();
		sess.save(c);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
