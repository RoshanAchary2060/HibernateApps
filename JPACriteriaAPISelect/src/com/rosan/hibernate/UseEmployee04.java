package com.rosan.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class); // we mention return type here
		Root root = cq.from(Employee.class);
		cq.select(cb.count(root));
		Query<Long> qry = sess.createQuery(cq);
		Long count = qry.getSingleResult();
		System.out.println("Total number of emp are " + count);
		sess.close();
		factory.close();
	}
}