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
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root.get("empName")); // root is as good as select empName
		Query<String> qry = sess.createQuery(cq);
		List<String> empList = qry.getResultList();
		Iterator<String> it = empList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		sess.close();
		factory.close();
	}
}
