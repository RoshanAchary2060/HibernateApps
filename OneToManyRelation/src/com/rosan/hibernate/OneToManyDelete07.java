package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDelete07 {

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
			System.out.println("Record found");
			Transaction tx = null;
			try {
				tx = sess.beginTransaction();
				sess.delete(dobj);
				tx.commit();
				System.out.println("Record deleted");
			} catch (Exception ex) {
				System.out.println("Error occured in deleting");
				tx.rollback();
			}
		} else {
			System.out.println("Record not found!");
		}
		sess.close();
		factory.close();
	}
}
