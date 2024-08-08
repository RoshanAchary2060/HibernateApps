package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		try {
			Query qry = sess.createQuery("From Employee");
			List<Employee> empList = qry.list();
			Iterator<Employee> it = empList.iterator();
			while (it.hasNext()) {
				Employee e = it.next();
				System.out.println(e);
			}
		} catch (Exception ex) {
			System.out.println("Problem occured!");
			ex.printStackTrace();
		} finally {
			if (sess != null) {
				sess.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}
}
