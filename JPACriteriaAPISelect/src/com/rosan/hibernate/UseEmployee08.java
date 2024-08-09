package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee08 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class); // we mention return type here
		Root root = cq.from(Employee.class);
		cq.select(root);
		Order order = cb.asc(root.get("empSal"));
		cq.orderBy(order);
		Query<Employee> qry = sess.createQuery(cq);
		List<Employee> list = qry.getResultList();
		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		sess.close();
		factory.close();
	}
}
