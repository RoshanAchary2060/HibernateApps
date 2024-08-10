package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyInsert03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Course cobj = sess.get(Course.class, 101);
		Course cobj2 = sess.get(Course.class, 102);

		Student s1 = new Student();
		s1.setStudentId(505);
		s1.setStudentName("Binod");
		s1.setMarks(95);

		Set<Course> st = new HashSet<>();
		st.add(cobj);
		st.add(cobj2);
		s1.setCourses(st);

		Transaction tx = sess.beginTransaction();
		sess.save(s1);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
