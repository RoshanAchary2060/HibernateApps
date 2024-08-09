package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee05 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Query qry = sess.createNamedQuery("empSal");
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter sal");
		double amt = kb.nextDouble();
		qry.setParameter("x", amt);
		List<Object[]> emplist = qry.list();
		Iterator<Object[]> it = emplist.iterator();
		while (it.hasNext()) {
			Object[] data = it.next();
			System.out.println(data[0] + ", " + data[1]);
		}
	}
}
