package com.rosan.main;

import java.util.Scanner;

import javax.persistence.PersistenceException;

import com.rosan.dao.AccountDAOImpl;
import com.rosan.dao.IAccountDAO;
import com.rosan.entity.Account;
import com.rosan.exception.InsufficientFundsException;

public class UseAccount {

	public static void main(String[] args) {
		Account acc = null;
		IAccountDAO dao = new AccountDAOImpl();
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
					result = dao.createAccount(acc);
					if (result) {
						System.out.println("Account created...");
					} else {
						System.out.println("Couldnot create account!");
					}
				} catch (PersistenceException ex) {
					System.out.println("Account with id " + acc.getAcctId() + " already present!");
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				}
				break;
			}

			case 2: {
				System.out.println("Enter acctId:");
				id = kb.nextInt();
				try {
					acc = dao.getAccountDetails(id);
					if (acc == null) {
						System.out.println("AccountId not found!");
					} else {
						System.out.println(acc);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				}
				break;
			}

			case 3: {
				System.out.println("Enter acctid:");
				id = kb.nextInt();
				System.out.println("Enter amount to withdraw:");
				bal = kb.nextDouble();
				try {

					result = dao.updateAccount(id, 'w', bal);
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
				break;
			}

			case 4: {
				System.out.println("Enter acctid:");
				id = kb.nextInt();
				System.out.println("Enter amount to deposit:");
				bal = kb.nextDouble();
				try {
					result = dao.updateAccount(id, 'd', bal);
					if (result) {
						System.out.println("Account updated...");
					} else {
						System.out.println("Cannot deposit the amount!");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				}
				break;
			}

			case 5: {
				System.out.println("Enter acctid:");
				id = kb.nextInt();
				try {
					result = dao.closeAccount(id);
					if (result) {
						System.out.println("Account closed");
					} else {
						System.out.println("Cannot close the account!");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Exception occured!");
				}
				break;
			}

			case 6: {
				System.out.println("Thank you for using the app!");
				kb.close();
				dao.closeResources();
				System.exit(0);
			}
			
			default: {
				System.out.println("Wrong Choice!");
			}
			}
		} while (true);
	}
}
