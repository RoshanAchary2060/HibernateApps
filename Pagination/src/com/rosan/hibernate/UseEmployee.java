package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
//		Query<Employee> qry = sess.getNamedQuery("findAllEmp");
		Query<Employee> qry = sess.createQuery("from Employee e order by e.empNo");
		int start = 0;
		int max = 3;
		while (true) {
			qry.setFirstResult(start);
			qry.setMaxResults(max);
			List<Employee> empList = qry.list();
			if (empList.size() == 0) {
				break;
			}
			System.out.println("Page no :: " + ((start / max) + 1));
			System.out.println("-----------------------");
			Iterator<Employee> it = empList.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			start += max;
		}

	}
}
