package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee10 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		try {
			System.out.println("Enter id");
			int id = kb.nextInt();
			Query qry = sess.createQuery("delete from Employee where empNo=:id");;
			qry.setParameter("id", id);
			Transaction tx = sess.beginTransaction();
			int ans = qry.executeUpdate();
			tx.commit();
			System.out.println(ans + " Records deleted...");
		} catch (Exception ex) {
			System.out.println("Problem occured!");
			ex.printStackTrace();
		} finally {
			if (sess != null) {
				sess.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}
}
