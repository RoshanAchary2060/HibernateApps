package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneInsert01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();

		Person p = new Person();
		p.setPersonId(101);
		p.setPersonName("Ram");
		p.setPersonAge(25);

		Address a = new Address();
		a.setCity("Bhopal");
		a.setStreet("Arera");
		a.setP(p);

		Transaction tx = sess.beginTransaction();
		sess.save(a);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
