package com.rosan.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Emp")
public class Employee {
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSal=" + empSal + ", depno=" + depno + "]";
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_generator")
//	@SequenceGenerator(name = "emp_generator", sequenceName = "myseq1", allocationSize = 1)
	@Column(name = "emp_no")
	private int empNo;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_sal")
	private double empSal;

	@ManyToOne
	@JoinColumn(name = "DNO")
	private Department depno;

	public Department getDepno() {
		return depno;
	}

	public void setDepno(Department depno) {
		this.depno = depno;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
}
