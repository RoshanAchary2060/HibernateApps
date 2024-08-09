package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Query<Employee> qry = sess.createNamedQuery("empbySal");
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter sal");
		double amt = kb.nextDouble();
		qry.setParameter("x", amt);
		List<Employee> emplist = qry.list();
		Iterator<Employee> it = emplist.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
