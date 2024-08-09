package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class UseEmployee10 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Criteria crit = sess.createCriteria(Employee.class);
		Criterion crn = Restrictions.gt("empSal", 10000.0);
		Criterion crn2 = Restrictions.like("empName", "A%");
		Criterion crn3 = Restrictions.and(crn, crn2);
		// we can directly write
//		crit.add(crn);
//		crit.add(crn2);
		crit.add(crn3);
		List<Employee> list = crit.list();
		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			System.out.println(e);
		}
		sess.close();
		factory.close();
	}
}
