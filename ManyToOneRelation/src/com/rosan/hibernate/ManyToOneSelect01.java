package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneSelect01 {

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
			System.out.println("Employee details");
			System.out.println(e.getEmpNo() + "," + e.getEmpName() + "," + e.getEmpSal());
			System.out.println("Retrieving Department");
			Department dobj = e.getDept();
			System.out.println(dobj);
		} else {
			System.out.println("Record not found");
		}
		sess.close();
		factory.close();
		System.out.println("Done");
	}
}
