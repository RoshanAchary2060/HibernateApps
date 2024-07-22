package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee11 {

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
			Employee e = sess.get(Employee.class, empNo);
			sess.close();
			e.setEmpSal(e.getEmpSal() + 1000);
			sess = factory.openSession();
			tx = sess.beginTransaction();
			System.out.println("Merge Record...");
			Employee f = (Employee) sess.merge(e);
			System.out.println(e==f);
			System.out.println("After method call");
			tx.commit();
			System.out.println("Updated salary :: " + f.getEmpSal());
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
