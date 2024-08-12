package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Set;

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
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();

		Department d = new Department();
		d.setDeptno(101);
		d.setDname("Information Tech");

		Employee e1 = new Employee();
		e1.setEmpNo(501);
		e1.setEmpName("Ram");
		e1.setEmpSal(50000);
		e1.setDepno(d);

		Employee e2 = new Employee();
		e2.setEmpNo(502);
		e2.setEmpName("Shyam");
		e2.setEmpSal(40000);
		e2.setDepno(d);
		
		Set<Employee> st = new HashSet<Employee>();
		st.add(e1);
		st.add(e2);
		d.setStaff(st);
		
		Transaction tx = sess.beginTransaction();
		sess.save(d);
		tx.commit();
		System.out.println("Recs saved");

		sess.close();
		sf.close();
	}
}
