package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseEmployee02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		SQLQuery qry = sess.createSQLQuery("select * from employee");
		qry.addEntity(Employee.class);
		List<Employee> emplist = qry.list();
		Iterator<Employee> it = emplist.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			System.out.println(e.getEmpName() + "," + e.getEmpNo() + "," + e.getEmpSal());
		}
	}
}
