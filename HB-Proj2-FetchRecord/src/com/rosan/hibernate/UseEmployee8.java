package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee8 {

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
			System.out.println("Enter empname");
			String name = kb.next();
			System.out.println("Enter empsal");
			Double sal = kb.nextDouble();
			tx = sess.beginTransaction();
			Employee e = new Employee();
			e.setEmpName(name);
			e.setEmpSal(sal);
			e.setEmpNo(empNo);
			System.out.println("SaveOrUpdate Record...");
			sess.saveOrUpdate(e);
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
