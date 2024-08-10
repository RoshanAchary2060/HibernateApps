package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToOneDelete02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		System.out.println("Enter sal");
		double sal = new java.util.Scanner(System.in).nextDouble();
		Query qry = sess.createQuery("delete from Employee where empSal>:x");
		qry.setParameter("x", sal);
		Transaction tx = sess.beginTransaction();
		int result = qry.executeUpdate();
		tx.commit();
		System.out.println(result + " emp deleted");
		sess.close();
		factory.close();
	}
}
