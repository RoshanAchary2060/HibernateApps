package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		System.out.println("Session created");
		Scanner kb = new Scanner(System.in);
		boolean done = true;
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			System.out.println("Enter empid:");
			int empNo = kb.nextInt();
			System.out.println("Enter empname");
			String name = kb.next();
			System.out.println("Enter empsal");
			double sal = kb.nextDouble();
			System.out.println("Enter deptno");
			int dno = kb.nextInt();
			Employee e = new Employee();
			e.setEmpNo(empNo);
			e.setEmpName(name);
			e.setEmpSal(sal);
			e.setDeptno(dno);
			System.out.println("Saving object in session");
			sess.save(e);
			System.out.println("Calling flush");
			sess.flush();
			System.out.println("Waiting");
			System.in.read();
		} catch (Exception ex) {
			System.out.println("Exception occured");
			ex.printStackTrace();
			done = false;
		} finally {
			if (tx != null) {
				if (done) {
					tx.commit();
					System.out.println("Object saved successfully");
				} else {
					tx.rollback();
					System.out.println("Couldnot save object!");
				}
				sess.close();
				factory.close();
				System.out.println("Bye");
			}
		}
	}
}
