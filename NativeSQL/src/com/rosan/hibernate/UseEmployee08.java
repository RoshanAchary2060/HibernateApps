package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee08 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		SQLQuery qry = sess.createSQLQuery("insert into employee values (?,?,?)");
		System.out.println("Enter id");
		int id = kb.nextInt();
		System.out.println("Enter name");
		String name = kb.next();
		System.out.println("enter salary");
		double amt = kb.nextDouble();
		qry.setParameter(1, id);
		qry.setParameter(2, name);
		qry.setParameter(3, amt);
		Transaction tx = sess.beginTransaction();
		int result = qry.executeUpdate();
		tx.commit();
		System.out.println(result + " record inserted...");
	}
}
