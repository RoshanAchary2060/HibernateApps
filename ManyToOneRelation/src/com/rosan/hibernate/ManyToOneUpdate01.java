package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToOneUpdate01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Employee e = sess.get(Employee.class, 501);
		if (e == null) {
			System.out.println("Record not found");
		} else {
			Transaction tx = sess.beginTransaction();
			e.setEmpSal(e.getEmpSal() + 1000);
			sess.update(e);
			tx.commit();
			System.out.println("Emp updated");
		}
		sess.close();
		factory.close();
	}
} 
