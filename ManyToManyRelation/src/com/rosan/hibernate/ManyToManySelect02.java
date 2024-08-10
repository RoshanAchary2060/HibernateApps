package com.rosan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToManySelect02 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Query<Course> qry = sess.createQuery("from Course", Course.class);
		List<Course> courseList = qry.list();
		if (courseList.size() > 0) {
			for (Course c : courseList) {
				System.out.println(c.getCourseId() + "," + c.getCourseName());
				System.out.println("---------------------");
				for (Student s : c.getStudents()) {
					System.out.println(s.getStudentId() + "," + s.getStudentName());
				}
			}
		}
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
