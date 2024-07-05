package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Configuration created");
		cfg.configure("hibernate.cfg.xml");
		System.out.println("configure() called");
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("SessionFactory created");
		Session sess = sf.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter emp no:");
		int eno = kb.nextInt();
		System.out.println("Calling get() first time");
		Employee emp = sess.get(com.rosan.hibernate.Employee.class, eno);
		if(emp != null) {
			System.out.println("EmpNo : " + emp.getEmpNo() );
			System.out.println("Ename : " + emp.getEmpName() );
			System.out.println("EmpSal : " + emp.getEmpSal() );
			System.out.println("We got Object of class " + emp.getClass());

		} else {
			System.out.println("Record not found!");
		}
		System.out.println("Calling get() second time");
		emp = sess.get(com.rosan.hibernate.Employee.class, eno);
		if(emp != null) {
			System.out.println("EmpNo : " + emp.getEmpNo() );
			System.out.println("Ename : " + emp.getEmpName() );
			System.out.println("EmpSal : " + emp.getEmpSal() );
		} else {
			System.out.println("Record not found!");
		}
		System.out.println("Calling get() third time");
		 emp = sess.get(com.rosan.hibernate.Employee.class, eno+1);
		if(emp != null) {
			System.out.println("EmpNo : " + emp.getEmpNo() );
			System.out.println("Ename : " + emp.getEmpName() );
			System.out.println("EmpSal : " + emp.getEmpSal() );
		} else {
			System.out.println("Record not found!");
		}
		sess.close();
		sf.close();
	}
}
