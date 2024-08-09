package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		cq.orderBy(cb.asc(root.get("empNo")));
		Query<Employee> qry = sess.createQuery(cq);
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
