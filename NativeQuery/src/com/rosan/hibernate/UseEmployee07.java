package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class UseEmployee07 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		NativeQuery<Employee> qry = sess.createNativeQuery("insert into employee values (?,?,?)", Employee.class);
		Scanner kb = new Scanner(System.in);
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
		kb.close();
	}
}
