package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BidirectionalUpdate03 {

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
			e.setEmpNo(507);
			e.setEmpName("Mahesh");
			e.setEmpSal(78000);

			Employee e2 = new Employee();
			e2.setEmpNo(508);
			e2.setEmpName("Mahesh");
			e2.setEmpSal(78000);

			d.getStaff().add(e);
			d.getStaff().add(e2);
			Transaction tx = sess.beginTransaction();
			sess.update(d);
			sess.flush();
			tx.commit();
			System.out.println("Emp rec updated");
		}
		sess.close();
		factory.close();
	}
}
