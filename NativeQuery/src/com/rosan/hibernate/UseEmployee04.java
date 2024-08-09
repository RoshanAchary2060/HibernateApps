package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

public class UseEmployee04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		NativeQuery qry = sess.createNativeQuery("select emp_name, emp_sal from employee");
//		qry.addScalar("emp_name", new StringType());
		qry.addScalar("emp_name", StringType.INSTANCE);
//		qry.addScalar("emp_sal", new DoubleType());
		qry.addScalar("emp_sal", DoubleType.INSTANCE);
		List<Object[]> emplist = qry.list();
		Iterator<Object[]> it = emplist.iterator();
		while (it.hasNext()) {
			Object[] data = it.next();
			String name = (String) data[0];
			Double sal = (Double) data[1];
			System.out.println(name + ", " + sal);
		}
	}
}
