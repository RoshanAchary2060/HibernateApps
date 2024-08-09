package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class UseEmployee8 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Criteria crit = sess.createCriteria(Employee.class);
		Criterion crn = Restrictions.in("empNo", 1, 2, 3, 4, 5,11,17);
		Criterion crn2 = Restrictions.not(crn);
		crit.add(crn2);
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
