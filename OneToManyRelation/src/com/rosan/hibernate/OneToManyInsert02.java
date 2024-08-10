package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyInsert02 {

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
		e1.setEmpNo(504);
		e1.setEmpName("Ram");
		e1.setEmpSal(50000.0);

		Employee e2 = new Employee();
		e2.setEmpNo(505);
		e2.setEmpName("Shyam");
		e2.setEmpSal(40000.0);

		Employee e3 = new Employee();
		e3.setEmpNo(506);
		e3.setEmpName("Harish");
		e3.setEmpSal(30000.0);

		Set<Employee> st = new HashSet<>();
		st.add(e1);
		st.add(e2);
		st.add(e3);

		dobj.setStaff(st);

		Transaction tx = sess.beginTransaction();
		try {
			sess.merge(dobj);
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