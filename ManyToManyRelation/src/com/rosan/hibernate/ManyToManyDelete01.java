package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDelete01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Course c = sess.get(Course.class, 101);
		if (c != null) {
			Transaction tx = sess.beginTransaction();
			sess.delete(c);
			tx.commit();
			System.out.println("Record deleted");
		}
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
