package com.rosan.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyDelete06 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter emp sal");
		double sal = kb.nextDouble();
		Query<Employee> qry = sess.createQuery("from Employee e where e.empSal>:x", Employee.class);
		qry.setParameter("x", sal);
		List<Employee> empList = qry.list();
		if (empList.size() > 0) {
			Transaction tx = sess.beginTransaction();
			try {
				for (Employee e : empList) {
					sess.delete(e);
					System.out.println(e.getEmpNo() + ", " + e.getEmpSal());
				}
				tx.commit();
				System.out.println("Records deleted");
			} catch (Exception ex) {
				tx.rollback();
				System.out.println("Error in deleting!");
			}

		} else {
			System.out.println("Record not found");
		}
		sess.close();
		factory.close();
		kb.close();
	}
}
