package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseEmployee03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess1 = sf.openSession();

		System.out.println("Calling get for the first time through sess1");
		Employee e = sess1.get(Employee.class, 101);
		if (e != null) {
			System.out.println("Details :: " + e);
		}
		System.out.println("Calling get for the second time through sess1");

		e = sess1.get(Employee.class, 101);
		if (e != null) {
			System.out.println("Details :: " + e);
		}
		sess1.evict(e);
		System.out.println("Calling get for the third time through sess1");

		e = sess1.get(Employee.class, 101);
		if (e != null) {
			System.out.println("Details :: " + e);
		}
		sess1.close();
		sf.close();
	}
}
