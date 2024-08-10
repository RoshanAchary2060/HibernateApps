package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneInsert01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();

		Department dobj = new Department();
		dobj.setDeptno(101);
		dobj.setDname("Information Tech");

		Employee e1 = new Employee();
		e1.setEmpNo(501);
		e1.setEmpName("Rajat");
		e1.setEmpSal(50000.0);
		e1.setDept(dobj);

		Employee e2 = new Employee();
		e2.setEmpNo(502);
		e2.setEmpName("Bimal");
		e2.setEmpSal(40000.0);
		e2.setDept(dobj);

		Employee e3 = new Employee();
		e3.setEmpNo(503);
		e3.setEmpName("Hari");
		e3.setEmpSal(30000.0);
		e3.setDept(dobj);

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