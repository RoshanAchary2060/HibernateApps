package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDelete02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Student s = sess.get(Student.class, 503);
		if (s != null) {
			Transaction tx = sess.beginTransaction();
			sess.delete(s);
			tx.commit();
			System.out.println("Student deleted");
		}
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
