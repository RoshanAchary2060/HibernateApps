package com.rosan.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee07 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Double> cq = cb.createQuery(Double.class); // we mention return type here
		Root root = cq.from(Employee.class);
		cq.select(cb.sum(root.get("empSal")));
		Query<Double> qry = sess.createQuery(cq);
		Double maxsal = qry.getSingleResult();
		System.out.println("Total salary is " + maxsal);
		sess.close();
		factory.close();
	}
}
