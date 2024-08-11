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
		Session sess = sf.openSession();
		System.out.println("Calling get for the first time");
		Employee e = sess.get(Employee.class, 101);
		if (e != null) {
			System.out.println("Details :: " + e);
		}
		System.out.println("Calling get for the second time");
		 e = sess.get(Employee.class, 101);
		if (e != null) {
			System.out.println("Details :: " + e);
		}
		sess.close();
		sf.close();
	}
}
