package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyInsert04 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Student s1 = sess.get(Student.class, 501);
		Student s2 = sess.get(Student.class, 502);

		Course c1 = new Course();
		c1.setCourseId(103);
		c1.setCourseName("JEE");

		Set<Student> set = new HashSet<>();
		set.add(s1);
		set.add(s2);

		c1.setStudents(set);

		Transaction tx = sess.beginTransaction();
		sess.save(c1);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
