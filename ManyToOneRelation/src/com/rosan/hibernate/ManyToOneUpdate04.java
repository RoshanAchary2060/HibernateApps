package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToOneUpdate04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Employee e = sess.get(Employee.class, 503);
		if (e != null) {
			e.setEmpSal(e.getEmpSal()+1000);
			e.getDept().setDname("HR");
			Transaction tx = sess.beginTransaction();
			sess.update(e);
			tx.commit();
			System.out.println("Emp updated");
		}
		sess.close();
		factory.close();
	}
}
