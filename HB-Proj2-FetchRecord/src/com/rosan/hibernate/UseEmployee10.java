package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee10 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		Transaction tx = null;
		try {
			System.out.println("Enter empid:");
			int empNo = kb.nextInt();
			Employee e = sess.get(Employee.class, empNo);
			System.out.println("Enter empname");
			String name = kb.next();
			System.out.println("Enter empsal");
			Double sal = kb.nextDouble();
			tx = sess.beginTransaction();
			e.setEmpName(name);
			e.setEmpSal(sal);
			System.out.println("Merge Record...");
			sess.merge(e);
			System.out.println("After method call");
			tx.commit();
			System.out.println("Record updated");

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
