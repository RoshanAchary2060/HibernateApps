package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDelete05 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter emp id");
		int eid = kb.nextInt();
		Employee e = sess.get(Employee.class, eid);
		if (e != null) {
			Transaction tx = sess.beginTransaction();
			try {
				sess.delete(e);
				tx.commit();
				System.out.println("Record deleted");
			} catch (Exception ex) {
				tx.rollback();
				System.out.println("Error occured!");
			}
		} else {
			System.out.println("Record not found");
		}
		sess.close();
		factory.close();
		kb.close();
	}
}
