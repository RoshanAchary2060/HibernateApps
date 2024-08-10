package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneInsert02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();

		Department dobj = new Department();
		dobj.setDeptno(102);
		dobj.setDname("Finance");

		Employee e1 = new Employee();
		e1.setEmpNo(504);
		e1.setEmpName("Ram");
		e1.setEmpSal(80000.0);
		e1.setDept(dobj);

		Employee e2 = new Employee();
		e2.setEmpNo(505);
		e2.setEmpName("Shyam");
		e2.setEmpSal(55000.0);
		e2.setDept(dobj);

		Employee e3 = new Employee();
		e2.setEmpNo(506);
		e2.setEmpName("Shirish");
		e2.setEmpSal(95000.0);
		e2.setDept(dobj);

		Transaction tx = sess.beginTransaction();
		try {
			sess.save(e1);
			sess.save(e2);
			sess.save(e3);
			tx.commit();
			System.out.println("Records saved...");
		} catch (Exception ex) {
			tx.rollback();
			System.out.println("Error occured!");
		} finally {
			if (sess != null) {
				sess.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}
}
