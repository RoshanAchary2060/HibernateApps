package com.rosan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManySelect01 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Course c = sess.get(Course.class, 101);
		if (c != null) {
			System.out.println("Course details : " + c.getCourseId() + "," + c.getCourseName());
			System.out.println("----------------------------------------");
			System.out.println("Student details");
			for (Student s : c.getStudents()) {
				System.out.println(s.getStudentId() + "," + s.getStudentName());
			}
		}
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
