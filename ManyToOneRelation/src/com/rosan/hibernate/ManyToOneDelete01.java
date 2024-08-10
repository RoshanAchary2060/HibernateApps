package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneDelete01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		System.out.println("Enter emp id");
		int id = new java.util.Scanner(System.in).nextInt();
		Employee e = sess.get(Employee.class, id);
		if (e != null) {
			Transaction tx = sess.beginTransaction();
			sess.delete(e);
			tx.commit();
			System.out.println("Emp deleted");
		} else {
			System.out.println("No emp found");
		}
		sess.close();
		factory.close();
	}
}
