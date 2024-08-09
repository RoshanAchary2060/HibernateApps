package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class UseEmployee03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		NativeQuery qry = sess.createNativeQuery("select emp_name, emp_sal from employee");
		List<Object[]> emplist = qry.list();
		Iterator<Object[]> it = emplist.iterator();
		while (it.hasNext()) {
			Object[] data = it.next();
			String name = (String) data[0];
			Number sal = (Number) data[1];
			System.out.println(name + ", " + sal);
		}
	}
}
