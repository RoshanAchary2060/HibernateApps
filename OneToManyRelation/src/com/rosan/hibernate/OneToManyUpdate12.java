package com.rosan.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyUpdate12 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Department dobj = sess.get(Department.class, 101);
		if (dobj == null) {
			System.out.println("No rec found");
			return;
		}
		dobj.setDname("Production");
		Set<Employee> staff = dobj.getStaff();
		for (Employee e : staff) {
			e.setEmpSal(e.getEmpSal() + 1000);
		}
		Transaction tx = sess.beginTransaction();
		sess.update(dobj);
		tx.commit();
		System.out.println("Records updated");
		sess.close();
		factory.close();
	}
}
