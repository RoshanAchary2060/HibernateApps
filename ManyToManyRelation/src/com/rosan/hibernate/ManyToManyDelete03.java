package com.rosan.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDelete03 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Course c = sess.get(Course.class, 102);
		if (c != null) {
			System.out.println("Record found");
			Transaction tx = sess.beginTransaction();
			try {
				Set<Student> s = c.getStudents();
				Iterator<Student> it = s.iterator();
				while (it.hasNext()) {
					Student st = it.next();
					if (st.getCourses().size() == 1) {
						sess.delete(st);
					} else {
						st.getCourses().remove(c);
					}
				}
				sess.delete(c);
				tx.commit();
				System.out.println("Record deleted");
			} catch (Exception ex) {
				System.out.println("Error occured!");
				ex.printStackTrace();
			}
		} else {
			System.out.println("Record not found!");
		}
		sess.close();
		factory.close();
		System.out.println("Thank You");
	}

}
