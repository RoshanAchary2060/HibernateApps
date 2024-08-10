package com.rosan.hibernate;

import java.util.Set;

public class Student {
	private int studentId;
	private String studentName;
	private int marks;

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	private Set<Course> courses;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", marks=" + marks + ", courses="
				+ courses + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
