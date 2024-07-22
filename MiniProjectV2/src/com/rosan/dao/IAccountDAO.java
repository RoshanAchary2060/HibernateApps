package com.rosan.dao;

import com.rosan.entity.Account;
import com.rosan.exception.InsufficientFundsException;

public interface IAccountDAO {
	public abstract boolean createAccount(Account obj);
	public abstract Account getAccountDetails(int acctid);
	public abstract boolean updateAccount(int id, char tr, double amt) throws InsufficientFundsException;
	public abstract boolean closeAccount(int acctid);
	public abstract void closeResources();
}
