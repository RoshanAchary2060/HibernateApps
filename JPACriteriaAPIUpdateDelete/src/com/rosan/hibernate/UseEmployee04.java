package com.rosan.hibernate;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee04{

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaDelete<Employee> cd = cb.createCriteriaDelete(Employee.class);
		Root<Employee> root = cd.from(Employee.class);
		Transaction tx = sess.beginTransaction();
		Query<Employee> qry = sess.createQuery(cd);
		int ans = qry.executeUpdate();
		tx.commit();
		System.out.println("Rec delete :: " + ans);
		sess.close();
		factory.close();
	}
}
