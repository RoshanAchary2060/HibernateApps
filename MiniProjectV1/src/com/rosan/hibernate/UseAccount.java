package com.rosan.hibernate;

import java.util.Scanner;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseAccount {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = null;
		Account acc = null;
		int id;
		double bal;
		int choice;
		boolean result;
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("Select an option:");
			System.out.println(
					"1. Create Account\n2. Get Account Details\n3. Withdraw Amount\n4. Deposit Amount\n5. Close Account\n6. Quit");
			choice = kb.nextInt();
			switch (choice) {
			case 1: {
				acc = new Account();
				System.out.println("Enter acctId:");
				acc.setAcctId(kb.nextInt());
				System.out.println("Enter acctName:");
				acc.setAcctName(kb.next());
				System.out.println("Enter acctBal");
				acc.setAcctBal(kb.nextDouble());
				try {
					sess = sf.openSession();
					result = createAccount(acc, sess);
					if (result) {
						System.out.println("Account created...");
					} else {
						System.out.println("Couldnot create account!");
					}
				}
				catch(PersistenceException ex) {
					System.out.println("Account with id " + acc.getAcctId()+ " already present!");
				}
				catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				} finally {
					if (sess != null) {
						sess.close();
					}
				}
				break;
			}

			case 2: {
				System.out.println("Enter acctId:");
				id = kb.nextInt();
				try {
					sess = sf.openSession();
					acc = getAccountDetails(id, sess);
					if (acc == null) {
						System.out.println("AccountId not found!");
					} else {
						System.out.println(acc);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				} finally {
					if (sess != null) {
						sess.close();
					}
				}
				break;
			}

			case 3: {
				System.out.println("Enter acctid:");
				id = kb.nextInt();
				System.out.println("Enter amount to withdraw:");
				bal = kb.nextDouble();
				try {
					sess = sf.openSession();
					result = updateAccountDetails(id, bal, 'w', sess);
					if (result) {
						System.out.println("Account updated!");
					} else {
						System.out.println("Cannot update the account!");
					}

				} catch (InsufficientFundsException ex) {
					System.out.println("Sorry Transaction failed!");
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				}

				finally {

					if (sess != null) {
						sess.close();
					}
				}
				break;
			}

			case 4: {
				System.out.println("Enter acctid:");
				id = kb.nextInt();
				System.out.println("Enter amount to deposit:");
				bal = kb.nextDouble();
				try {
					sess = sf.openSession();
					result = updateAccountDetails(id, bal, 'd', sess);
					if (result) {
						System.out.println("Account updated...");
					} else {
						System.out.println("Cannot deposit the amount!");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				} finally {
					if (sess != null) {
						sess.close();
					}
				}
				break;
			}

			case 5: {
				System.out.println("Enter acctid:");
				id = kb.nextInt();
				try {
					sess = sf.openSession();
					result = closeAccount(id, sess);
					if (result) {
						System.out.println("Account closed");
					} else {
						System.out.println("Cannot close the account!");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				} finally {
					if (sess != null) {
						sess.close();
					}
				}
				break;
			}

			case 6: {
				System.out.println("Thank you for using the app!");
				kb.close();
				sf.close();
				System.exit(0);
			}

			default: {
				System.out.println("Wrong Choice!");
			}
			}
		} while (true);

	}

	private static boolean closeAccount(int id, Session sess) {
		Transaction tx = sess.beginTransaction();
		Account acc = getAccountDetails(id, sess);
		if (acc == null) {
			tx.commit();
			return false;
		}
		sess.delete(acc);
		tx.commit();
		return true;
	}

	private static boolean updateAccountDetails(int id, double bal, char c, Session sess)
			throws InsufficientFundsException {
		Transaction tx = sess.beginTransaction();
		Account acc = getAccountDetails(id, sess);
		if (acc == null) {
			tx.commit();
			return false;
		}
		if (c == 'w') {
			if (acc.getAcctBal() < bal) {
				tx.commit();
				throw new InsufficientFundsException("Balance too low!");
			}
			acc.setAcctBal(acc.getAcctBal() - bal);
		} else {
			acc.setAcctBal(acc.getAcctBal() + bal);
		}
		tx.commit();
		return true;
	}

	private static Account getAccountDetails(int id, Session sess) {
		Account acc = sess.get(Account.class, id);
		return acc;
	}

	private static boolean createAccount(Account acc, Session sess) throws PersistenceException{
		Transaction tx = sess.beginTransaction();
		sess.save(acc);
		tx.commit();
		return true;
	}

}
