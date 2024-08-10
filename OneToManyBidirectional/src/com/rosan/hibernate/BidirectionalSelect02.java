package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalSelect02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Employee e = sess.get(Employee.class, 501);
		if (e != null) {
			System.out.println("Emp details");
			System.out.println(e);
			System.out.println("Retrieving dept");
			System.out.println(e.getDept());
		}
		sess.close();
		factory.close();
	}
}
