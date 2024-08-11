package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseEmployee02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess1 = sf.openSession();
		Session sess2 = sf.openSession();

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

		System.out.println("Calling get for the first time through sess2");
		Employee f = sess2.get(Employee.class, 101);
		if (f != null) {
			System.out.println("Details :: " + f);
		}
		System.out.println("Calling get for the second time through sess2");
		f = sess2.get(Employee.class, 101);
		if (f != null) {
			System.out.println("Details :: " + f);
		}

		sess1.close();
		sess2.close();
		sf.close();
	}
}
