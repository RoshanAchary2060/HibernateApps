package com.rosan.hibernate;

class Person {
	private int age;
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}

public class Example1 {

	public static void main(String[] args) {
		Person p1 = new Person(25, "Roshan");
		System.out.println(p1);
	}

}
