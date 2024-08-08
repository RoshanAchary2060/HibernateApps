package com.rosan.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee7 {

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
			System.out.println("Enter empSal");
			double sal = kb.nextDouble();
			Employee e = new Employee();
			e.setEmpNo(id);
			e.setEmpSal(sal);
			Query qry = sess
					.createQuery("select e.empName, e.empSal from Employee e where e.empNo> :empNo and e.empSal > :empSal");
			qry.setProperties(e);
			List empList = qry.list();
			Iterator it = empList.iterator();
			while (it.hasNext()) {
				Object[] data = (Object[]) it.next();
				System.out.println(data[0] + ", " + data[1]);
			}
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
