package com.rosan.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyInsert01 {

	public ManyToManyInsert01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Course cobj = new Course();
		cobj.setCourseId(101);
		cobj.setCourseName("Java SE");

		Student s1 = new Student();
		s1.setStudentId(501);
		s1.setStudentName("Ramesh");
		s1.setMarks(80);

		Student s2 = new Student();
		s2.setStudentId(502);
		s2.setStudentName("Nitin");
		s2.setMarks(70);

		Set<Student> javaStudents = new HashSet<Student>();
		javaStudents.add(s1);
		javaStudents.add(s2);

		cobj.setStudents(javaStudents);
		Transaction tx = sess.beginTransaction();
		sess.save(cobj);
		tx.commit();
		System.out.println("Record inserted");
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
