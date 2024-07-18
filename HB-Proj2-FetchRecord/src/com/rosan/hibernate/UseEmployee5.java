package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee5 {

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
		try {
			tx = sess.beginTransaction();
			System.out.println("Enter empid:");
			int empNo = kb.nextInt();
			System.out.println("Enter empname");
			String name = kb.next();
			System.out.println("Enter empsal");
			double sal = kb.nextDouble();
			Employee e = new Employee();
			e.setEmpNo(empNo);
			e.setEmpName(name);
			e.setEmpSal(sal);
			System.out.println("updating object in session");
			sess.update(e);
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
