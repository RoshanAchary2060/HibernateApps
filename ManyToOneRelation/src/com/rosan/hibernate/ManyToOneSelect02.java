package com.rosan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToOneSelect02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Query<Employee> qry = sess.createQuery("From Employee", Employee.class);
		List<Employee> empList = qry.list();
		for (Employee e : empList) {
			System.out.println("Emp Details");
			System.out.println(e);
			Department d = e.getDept();
			System.out.println("Department details");
			System.out.println(d);
		}
		sess.close();
		factory.close();
	}
}
