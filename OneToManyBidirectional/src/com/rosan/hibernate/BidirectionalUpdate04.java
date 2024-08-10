package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BidirectionalUpdate04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Department d = sess.get(Department.class, 101);
		if (d != null) {
			Employee e = new Employee();
			e.setEmpNo(509);
			e.setEmpName("Mister");
			e.setEmpSal(78000);
			e.setDept(d);

			Employee e2 = new Employee();
			e2.setEmpNo(510);
			e2.setEmpName("George");
			e2.setEmpSal(68000);
			e2.setDept(d);

			Transaction tx = sess.beginTransaction();
			sess.save(e);
			sess.save(e2);
			sess.flush();
			tx.commit();
			System.out.println("Emp rec updated");
		}
		sess.close();
		factory.close();
	}
}
