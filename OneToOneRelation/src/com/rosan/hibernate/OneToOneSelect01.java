package com.rosan.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneSelect01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter person id");
		int id = kb.nextInt();
		Person p = sess.get(Person.class, id);

		if (p != null) {
			System.out.println(p.getPersonName() + " , " + p.getPersonAge());
		} else {
			System.out.println("Record not found!");
		}
		sess.close();
		factory.close();
		kb.close();
		System.out.println("Thank You");
	}

}
