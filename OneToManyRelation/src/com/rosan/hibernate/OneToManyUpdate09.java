package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyUpdate09 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();

		Employee e = sess.get(Employee.class, 501);
		if (e == null) {
			System.out.println("Record not found");
			return;
		}
		System.out.println("Before update :: " + e);
		Transaction tx = sess.beginTransaction();
		e.setEmpSal(e.getEmpSal() * 0.1);
		sess.update(e);
		tx.commit();
		System.out.println("After update :: " + e);
		sess.close();
		factory.close();
	}
}
