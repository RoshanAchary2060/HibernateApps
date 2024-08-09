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

public class UseEmployee03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Employee> root = cq.from(Employee.class);
		cq.multiselect(root.get("empName"), root.get("empSal"));
		Query<Object[]> qry = sess.createQuery(cq);
		List<Object[]> empList = qry.getResultList();
		Iterator<Object[]> it = empList.iterator();
		while (it.hasNext()) {
			Object[] data = it.next();
			System.out.println(data[0] + "," + data[1]);
		}
		sess.close();
		factory.close();
	}
}
