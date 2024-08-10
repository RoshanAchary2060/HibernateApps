package com.rosan.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManySelect03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = factory.openSession();
		Department dobj = sess.get(Department.class, 101);
		if (dobj != null) {
			System.out.println(dobj.getDeptno() + " , " + dobj.getDname());
			System.out.println("--------------------------------------------");
			Set<Employee> staff = dobj.getStaff();
			System.out.println(staff);
//			for (Employee o : staff) {
//				Employee e = o;
//				System.out.println(e.getEmpNo() + " , " + e.getEmpName() + " , " + e.getEmpSal() + " , " + e.getDno());
//			}
		}
		sess.close();
		factory.close();
		System.out.println("Bye");
	}
}
