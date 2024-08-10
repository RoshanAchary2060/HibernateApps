package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyDelete08 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Query qry = sess.createQuery("from Department", Department.class);
		List<Department> deptList = qry.list();
		if (deptList.size() == 0) {
			System.out.println("No record found!");
			return;
		}
		Iterator<Department> it = deptList.iterator();
		Transaction tx = sess.beginTransaction();
		while (it.hasNext()) {
			Department dobj = it.next();
			sess.delete(dobj);
		}
		tx.commit();
		System.out.println("Record deleted");
		sess.close();
		factory.close();
	}
}
