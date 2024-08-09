package com.rosan.hibernate;

import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee14 {

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
		cq.multiselect(root.get("empName"), root.get("empSal"));
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter emp no");
		int eno = kb.nextInt();
		Predicate pd = cb.equal(root.get("empNo"), eno);
		cq.where(pd);
		Query<Object[]> qry = sess.createQuery(cq);
		try {
		Object[] data = qry.getSingleResult();
		String name = (String) data[0];
		Double sal = (Double) data[1];
		System.out.println(name + " : " + sal);
		}catch(NoResultException ex) {
			System.out.println("Sorry no record found!");
		}
		sess.close();
		factory.close();
		System.out.println("Program closed...");
	}
}
