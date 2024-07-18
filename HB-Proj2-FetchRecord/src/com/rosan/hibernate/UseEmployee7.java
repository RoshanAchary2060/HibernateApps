package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee7 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory craeted");
		Session sess = factory.openSession();
		System.out.println("Session created");
		Scanner kb = new Scanner(System.in);
		Transaction tx = null;
		System.out.println("Enter empid:");
		int empNo = kb.nextInt();
		try {
			tx = sess.beginTransaction();
			Employee e = sess.get(Employee.class, empNo);
			if (e == null) {
				System.out.println("Sorry, Record not found!");
			} else {
				System.out.println("Enter empname");
				String name = kb.next();
				e.setEmpName(name);
				System.out.println("Enter empsal");
				Double sal = kb.nextDouble();
				e.setEmpSal(sal);
				System.out.println("Updating Record...");
				sess.update(e);
				tx.commit();
				System.out.println("Record updated");
			}

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
