package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee11 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class); // we mention return type here
		Root<Employee> root = cq.from(Employee.class);
		cq.multiselect(root.get("empSal"), cb.count(root));
		cq.groupBy(root.get("empSal"));
		Predicate pd = cb.greaterThan(root.get("empSal"), 40000.0);
		cq.having(pd);
		Query<Object[]> qry = sess.createQuery(cq);
		List<Object[]> list = qry.getResultList();
		Iterator<Object[]> it = list.iterator();
		while (it.hasNext()) {
			Object[] data = it.next();
			System.out.println((Double) data[0] + " : " + (Long) data[1]);
		}
		sess.close();
		factory.close();
	}
}
