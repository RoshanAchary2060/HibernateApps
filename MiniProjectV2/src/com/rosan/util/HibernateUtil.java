package com.rosan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf = null;
	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
		} catch (ExceptionInInitializerError ex) {
			System.out.println("Error in hibernateutil");
			throw new ExceptionInInitializerError("Exception in sessionfactory creation");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	public static void closeSessionFactory() {
		if (sf != null) {
			sf.close();
		}
	}
}
