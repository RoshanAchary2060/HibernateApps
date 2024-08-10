package com.rosan.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManySelect04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Query<Department> qry = sess.createQuery("from Department");
		List<Department> depList = qry.list();
		for (Department dobj : depList) {
			System.out.println(dobj.getDeptno() + " , " + dobj.getDname());
			Set staff = dobj.getStaff();
			for (Object o : staff) {
				Employee e = (Employee) o;
				System.out.println(e);
			}
		}
		sess.close();
		factory.close();
		System.out.println("Bye");
	}
}
