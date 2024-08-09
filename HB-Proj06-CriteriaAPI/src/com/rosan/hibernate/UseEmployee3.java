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

public class UseEmployee3 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Criteria crit = sess.createCriteria(Employee.class);
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter id");
		int id = kb.nextInt();
		Criterion crn = Restrictions.eq("empNo", id);
		crit.add(crn);
		List<Employee> list = crit.list();
		if (list.size() == 0) {
			System.out.println("Record not found!");
			return;
		}
		Iterator<Employee> it = list.iterator();
		Employee e = it.next();
		System.out.println(e);
		sess.close();
		factory.close();
	}
}
