package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class UseEmployee02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		NativeQuery<Employee> qry = sess.createNativeQuery("select * from employee", Employee.class);
		List<Employee> emplist = qry.list();
		Iterator<Employee> it = emplist.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
