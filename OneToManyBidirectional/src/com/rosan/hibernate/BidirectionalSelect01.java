package com.rosan.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalSelect01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Department dobj = sess.get(Department.class, 101);
		if (dobj != null) {
			System.out.println(dobj.getDeptno() + "," + dobj.getDname());
			Set<Employee> staff = dobj.getStaff();
			for (Employee e : staff) {
				System.out.println(e);
			}
		} else {
			System.out.println("Record not found");
		}
		sess.close();
		factory.close();
		System.out.println("Done");
	}
}
