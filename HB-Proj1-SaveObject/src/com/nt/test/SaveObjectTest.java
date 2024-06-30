package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
	public static void main(String [] args) {
		Configuration cfg = null;
		SessionFactory factory = null;
		Session sess = null;
		Product prod = null;
		Transaction tx = null;
		boolean flag = false;
		// activate hibernate f/w (bootstrap hibernate)
		cfg = new Configuration();
		// supply hibernate cfg file as input file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		// build Session Factory
		factory = cfg.buildSessionFactory();
		// open session
		sess = factory.openSession();
		// create Entity object to save with DB s/w
		prod = new Product();
		prod.setPid(444);
		prod.setPname("table");
		prod.setPrice(6000);
		prod.setQty(2);
		try {
			tx = sess.beginTransaction(); // internally calls conn.setAutoCommit(false) to begin the Tx
			// save object
			sess.save(prod);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			// commit or rollback Tx
			if (flag == true) {
				tx.commit(); // internally calls conn.commit()
				System.out.println("Object is saved");
			} else {
				tx.rollback(); // internally calls conn.rollback()
				System.out.println("object is not saved");
			}
			// close session obj
			sess.close();
			// close SessionFactory
			factory.close();
		}
	}
}
