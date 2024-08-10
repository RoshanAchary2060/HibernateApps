package com.rosan.hibernate;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayList<String> months = new ArrayList<>();
		months.add("Jan");
		months.add("Feb");
		months.add("Mar");
		months.add("Apr");
		Iterator<String> it = months.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
			if (s.startsWith("J")) {
				months.remove(s);
			}
		}
		System.out.println("After removing");
		System.out.println(months);
	}

}
