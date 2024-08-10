package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyInsert02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Course cobj = new Course();
		cobj.setCourseId(102);
		cobj.setCourseName("Python");

		Student s1 = new Student();
		s1.setStudentId(503);
		s1.setStudentName("Ram");
		s1.setMarks(90);

		Student s2 = new Student();
		s2.setStudentId(504);
		s2.setStudentName("Niraj");
		s2.setMarks(70);

		Set<Course> st = new HashSet<>();
		st.add(cobj);
		s1.setCourses(st);
		s2.setCourses(st);

		Transaction tx = sess.beginTransaction();
		sess.save(s1);
		sess.save(s2);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
