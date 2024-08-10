package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToOneUpdate02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Query qry = sess.createQuery("update Employee set dno=:x where empNo=:y");
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter empNo");
		int eno = kb.nextInt();
		System.out.println("Enter deptno");
		int dno = kb.nextInt();
		qry.setParameter("x", dno);
		qry.setParameter("y", eno);
		Transaction tx = sess.beginTransaction();
		int result = qry.executeUpdate();
		tx.commit();
		System.out.println(result + " emp updated");
		sess.close();
		factory.close();
	}
}
