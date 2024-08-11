package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");

		Session sess1 = sf.openSession();
		System.out.println("Calling get for the first time");
		Employee e = sess1.get(Employee.class, 101);
		System.out.println("Details :: " + e);
		sess1.close();

		Session sess2 = sf.openSession();
		System.out.println("Calling get for the second time");
		Employee e2 = sess2.get(Employee.class, 101);
		System.out.println("Details :: " + e2);
		sess2.close();
		sf.close();
	}
}
