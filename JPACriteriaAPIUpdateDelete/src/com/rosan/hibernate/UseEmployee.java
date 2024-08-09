package com.rosan.hibernate;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaUpdate<Employee> cu = cb.createCriteriaUpdate(Employee.class);
		Root<Employee> root = cu.from(Employee.class);
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter sal");
		double sal = kb.nextDouble();
		cu.set(root.get("empSal"), sal);
		Transaction tx = sess.beginTransaction();
		Query<Employee> qry = sess.createQuery(cu);
		int ans = qry.executeUpdate();
		tx.commit();
		System.out.println("Rec updated :: " + ans);
		sess.close();
		factory.close();
	}
}
