package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class UseEmployee05 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("enter salary");
		double amt = kb.nextDouble();
		SQLQuery qry = sess.createSQLQuery("select * from employee where emp_sal >:amt");
		qry.setParameter("amt", amt);
		qry.addEntity(Employee.class);
		List<Employee> emplist = qry.list();
		Iterator<Employee> it = emplist.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
