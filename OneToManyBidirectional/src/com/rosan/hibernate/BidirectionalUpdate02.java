package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BidirectionalUpdate02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Employee e = sess.get(Employee.class, 501);
		if(e!=null) {
			System.out.println(e);
			e.setEmpSal(e.getEmpSal()+1000);
			Transaction tx = sess.beginTransaction();
			sess.update(e);
			sess.flush();
			tx.commit();
			System.out.println("Emp rec updated");
		}
		sess.close();
		factory.close();
	}
}
