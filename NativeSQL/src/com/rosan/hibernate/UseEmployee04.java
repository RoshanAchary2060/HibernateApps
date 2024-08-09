package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
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
		SQLQuery qry = sess.createSQLQuery("select * from employee");
		qry.addScalar("emp_no", new IntegerType());
		qry.addScalar("emp_name", new StringType());
		qry.addScalar("emp_sal", new DoubleType());
		List<Object[]> emplist = qry.list();
		Iterator<Object[]> it = emplist.iterator();
		while (it.hasNext()) {
			Object[] data = it.next();
			Integer eno = (Integer) data[0];
			String ename = (String) data[1];
			Double esal = (Double) data[2];
			System.out.println(eno + " , " + ename + " , " + esal);
		}
	}
}
