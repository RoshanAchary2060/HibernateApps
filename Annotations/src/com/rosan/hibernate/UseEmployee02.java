package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = sf.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter name");
		String name = kb.next();
		System.out.println("Enter sal");
		double sal = kb.nextDouble();
		Employee e = new Employee();
		e.setEmpName(name);
		e.setEmpSal(sal);
		Transaction tx = sess.beginTransaction();
		sess.save(e);
		tx.commit();
		System.out.println("Rec saved");
		sess.close();
		sf.close();
		kb.close();
	}
}
