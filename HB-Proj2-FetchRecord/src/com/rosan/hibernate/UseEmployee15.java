package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee15 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			System.out.println("Enter empid:");
			int empNo = kb.nextInt();
			System.out.println("Calling load");
			Employee e = sess.load(Employee.class, empNo);
			System.out.println("Calling delete()");
			sess.delete(e);
			System.out.println("Calling commit");
			tx.commit();

		} catch (Exception ex) {
			System.out.println("Exception occured");
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();
				System.out.println("Rollback done");
			}
		} finally {
			sess.close();
			factory.close();
		}
	}
}
