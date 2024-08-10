package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyUpdate10 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter deptno");
		int deptno = kb.nextInt();
		Query qry = sess.createQuery("update Employee set empSal=empSal + empSal*0.1 where dno=:x");
		qry.setParameter("x", deptno);
		Transaction tx = sess.beginTransaction();
		int rows = qry.executeUpdate();
		tx.commit();
		System.out.println(rows + " Rec updated");
		kb.close();
		sess.close();
		factory.close();
	}
}
