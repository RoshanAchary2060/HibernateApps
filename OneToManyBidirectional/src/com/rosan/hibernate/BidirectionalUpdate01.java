package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BidirectionalUpdate01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Department dobj = sess.get(Department.class,101);
		if(dobj!=null) {
			System.out.println(dobj);
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
