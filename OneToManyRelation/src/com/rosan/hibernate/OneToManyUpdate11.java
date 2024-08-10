package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyUpdate11 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Department dobj = sess.get(Department.class, 101);
		System.out.println("Before update :: dname :: " + dobj.getDname());
		dobj.setDname("IT");
		Transaction tx = sess.beginTransaction();
		sess.update(dobj);
		tx.commit();
		System.out.println("After update :: dname :: " + dobj.getDname());
		sess.close();
		factory.close();
	}
}
