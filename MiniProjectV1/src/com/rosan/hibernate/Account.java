package com.rosan.hibernate;

public class Account {

	private int acctId;
	private String acctName;
	private double acctBal;

	public Account() {

	}

	@Override
	public String toString() {
		return "Account [acctid=" + acctId + ", acctName=" + acctName + ", acctBal=" + acctBal + "]";
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public double getAcctBal() {
		return acctBal;
	}

	public void setAcctBal(double acctBal) {
		this.acctBal = acctBal;
	}

}
