package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToOneUpdate03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);

		System.out.println("Enter deptno");
		int dno = kb.nextInt();
		Department dobj = sess.get(Department.class, dno);

		if (dobj != null) {
			dobj.setDname("Production");
			Transaction tx = sess.beginTransaction();
			sess.update(dobj);
			tx.commit();
			System.out.println("Dept updated");
		}
		sess.close();
		factory.close();
	}
}
