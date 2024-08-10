package com.rosan.hibernate;

import java.util.Set;

public class Department {
	private int deptno;
	private String dname;
	private Set<Employee> staff;

	public Set<Employee> getStaff() {
		return staff;
	}

	public void setStaff(Set<Employee> staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", staff=" + staff + "]";
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}
