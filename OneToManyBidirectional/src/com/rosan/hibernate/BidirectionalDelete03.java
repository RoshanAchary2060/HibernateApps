package com.rosan.hibernate;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BidirectionalDelete03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		Department d = sess.get(Department.class, 101);
		if (d != null) {
			Set<Employee> staff = d.getStaff();
			Transaction tx = sess.beginTransaction();
			Iterator<Employee> it = staff.iterator();
			while (it.hasNext()) {
				Employee e = it.next();
				System.out.println(e.getEmpName() + " \t Delete (yes/no)?");
				String choice = kb.next();
				if (choice.equalsIgnoreCase("yes")) {
					it.remove();
				}
			}
			sess.update(d);
			tx.commit();
		}
		System.out.println("Emp deleted");
		sess.close();
		factory.close();
		kb.close();
	}
}
