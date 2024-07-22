package com.rosan.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rosan.entity.Account;
import com.rosan.exception.InsufficientFundsException;
import com.rosan.util.HibernateUtil;

public class AccountDAOImpl implements IAccountDAO {

	@Override
	public boolean createAccount(Account obj) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(obj);
		tx.commit();
		sess.close();
		return true;
	}

	@Override
	public Account getAccountDetails(int acctid) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Account acc = (Account) sess.get(Account.class, acctid);
		return acc;
	}

	@Override
	public boolean updateAccount(int id, char tr, double amt) throws InsufficientFundsException {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		Account acc = getAccountDetails(id);
		if (acc == null) {
			tx.commit();
			return false;
		}
		if (tr == 'w') {
			if (acc.getAcctBal() < amt) {
				tx.commit();
				throw new InsufficientFundsException("Balance too low!");
			}
			acc.setAcctBal(acc.getAcctBal() - amt);
		} else {
			acc.setAcctBal(acc.getAcctBal() + amt);
		}
		sess.update(acc);
		tx.commit();
		sess.close();
		return true;
	}

	@Override
	public boolean closeAccount(int acctid) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		Account acc = this.getAccountDetails(acctid);
		if (acc == null) {
			tx.commit();
			return false;
		}

		sess.delete(acc);
		tx.commit();
		sess.close();
		return true;
	}

	@Override
	public void closeResources() {
		HibernateUtil.closeSessionFactory();
	}

}
